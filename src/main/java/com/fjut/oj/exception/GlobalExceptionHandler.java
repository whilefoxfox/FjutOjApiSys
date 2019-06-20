package com.fjut.oj.exception;

import com.fjut.oj.util.JsonInfo;

import org.apache.log4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

/**
 * TODO: 暂时未设置保存到数据库中的方法，后面设置定时任务将日志中的东西写入数据库
 * @Author: axiang
 * @Despriction: 全局异常处理类，将异常保存到数据库中
 * @Date:Created in 9:58 2019/6/20
 * @Modify By:
 */
@ControllerAdvice()
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonInfo handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("参数解析失败", e);

        jsonInfo.addInfo("参数解析失败！");
        return jsonInfo;
    }

    /**
     * 403 - FORBIDDEN
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public JsonInfo handleHttpStatusForbiddenException(Exception e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("拒绝访问", e);
        jsonInfo.addInfo("拒绝访问！");
        return jsonInfo;
    }


    /**
     * 404 - NOT_FOUND 暂时无效，404将由拦截器处理，不会返回异常
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonInfo handleHttpStatusNotFoundException(Exception e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("页面未找到", e);
        jsonInfo.addInfo("页面未找到！");
        return jsonInfo;
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonInfo handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("不支持当前请求方法", e);
        jsonInfo.addInfo("不支持当前请求方法");
        return jsonInfo;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public JsonInfo handleHttpMediaTypeNotSupportedException(Exception e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("不支持当前媒体类型", e);
        jsonInfo.addInfo("不支持当前媒体类型");
        return jsonInfo;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public JsonInfo handleException(Exception e) {
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setFail();
        LOGGER.error("服务运行异常", e);
        if(e instanceof NullPointerException)
        {
            jsonInfo.addInfo("参数为空错误！");
        }
        else if (e instanceof NumberFormatException) {
            jsonInfo.addInfo("字符解析数字错误！");
        }
        else if (e instanceof SQLException) {
            jsonInfo.addInfo("SQL语句错误！");
        }
        else{
            jsonInfo.addInfo("其他错误！");
        }

        e.printStackTrace();
        return jsonInfo;
    }


}
