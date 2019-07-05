package com.fjut.oj.exception;


import com.fjut.oj.pojo.Log;
import com.fjut.oj.service.LogService;
import com.fjut.oj.util.JsonInfo;

import net.sf.json.JSON;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Date;

/**
 * TODO: 暂时设计为得到Exception直接保存到数据库中，后面设置定时任务将文件中的日志写入数据库
 *
 * @Author: axiang
 * @Despriction: 全局异常处理类，将异常信息保存到数据库中，只返回前端带错误提示的JSON字符串
 * 返回JSON字符串结构为：{code:400 msg:"异常信息" datas:[]}
 * @Date:Created in 9:58 2019/6/20
 * @Modify By:
 */
@ControllerAdvice()
@ResponseBody
public class GlobalExceptionHandler {
    @Autowired
    LogService logService;

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonInfo handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = "请求解析失败";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
    }

    /**
     * 401 - Unauthorized
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JsonInfo handleUnauthorizedException(HttpMessageNotReadableException e) {
        String msg = "请求解析失败";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
    }

    /**
     * 403 - FORBIDDEN
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public JsonInfo handleHttpStatusForbiddenException(Exception e) {
        String msg = "拒绝访问";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
    }


    /**
     * 404 - NOT FOUND
     * FIXME:暂时无效，404将由拦截器处理，不会返回异常
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonInfo handleHttpStatusNotFoundException(Exception e) {
        String msg = "页面未找到";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonInfo handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String msg = "不支持当前请求方法";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public JsonInfo handleHttpMediaTypeNotSupportedException(Exception e) {
        String msg = "不支持当前媒体类型";
        LOGGER.error(msg, e);
        addExceptionToDatabase(e);
        return jsonInfoError(msg);
//        throw new BusinessException("不支持当前媒体类型");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public JsonInfo handleException(Exception e) {
        String msg;
        LOGGER.error("服务运行异常", e);
        addExceptionToDatabase(e);
        if (e instanceof NullPointerException) {
            msg = "参数为空错误！";
        } else if (e instanceof NumberFormatException) {
            msg = "参数解析错误！";
        } else if (e instanceof SQLException) {
            msg = "SQL语句错误！";
        } else {
            msg = "系统错误！";
        }
        return jsonInfoError(msg);
    }


    /**
     * 返回Json语句，设置为Error
     *
     * @param msg
     * @return
     */
    private JsonInfo jsonInfoError(String msg) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setError(msg);
        return jsonInfo;
    }

    /**
     * 将错误信息存入数据库中
     *
     * @param e
     */
    private void addExceptionToDatabase(Exception e) {
        Log log = new Log();
        log.setText(getErrorInfoFromException(e));
        log.setTime(new Date());
        logService.insertLog(log);

    }

    /**
     * 获取Exception中错误详情的字符串
     *
     * @param e
     * @return
     */
    private String getErrorInfoFromException(Exception e) {
        String res = "";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            e.printStackTrace(pw);
            res = sw.toString();
            pw.close();
            sw.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return res;
    }


}
