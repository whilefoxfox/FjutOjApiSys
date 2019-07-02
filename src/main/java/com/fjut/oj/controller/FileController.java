package com.fjut.oj.controller;

import com.fjut.oj.util.JsonInfo;
import org.codehaus.plexus.util.IOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author: wyx
 * @Despriction: 文件上传控制器
 * @Date:Created in 10:34 2019/7/2
 * @Modify By:
 */
@Controller
@CrossOrigin
@RequestMapping("/file")
@ResponseBody
public class FileController {
    /**
     * FIXME:部署时替换为生产环境部署路径
     */
    private static String BASEFILEPATH = "D:\\个人专用\\OJ项目\\OJFile\\";
    private static String BASEPICTUREPATH = "D:\\个人专用\\OJ项目\\OJPicture\\";
    private static String VERIFYPICPATH = "VerifyPic\\";


    @RequestMapping("/uploadPic")
    public JsonInfo uploadPicture2(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        String username = multipartRequest.getParameter("username");
        String verifyType = multipartRequest.getParameter("verifyType");
        if (null != username) {
            MultipartFile multipartFile = multipartRequest.getFile("file");
            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            String dateStr = format.format(today);
            // 保存文件名为 例：admin-1-20190702.jpg
            String imgPath = BASEPICTUREPATH + VERIFYPICPATH + username + "-" + verifyType + "-" + dateStr + ".jpg";
            System.out.println(imgPath);
            try {
                InputStream is = multipartFile.getInputStream();
                OutputStream out = new FileOutputStream(imgPath);
                IOUtil.copy(is, out);
                System.out.println(multipartFile.getOriginalFilename());
                out.close();
                is.close();
                jsonInfo.setSuccess("文件保存成功！");
            } catch (Exception e) {
                jsonInfo.setError("文件储存错误！");
            }
        } else {
            jsonInfo.setFail("用户名为空！");
        }
        return jsonInfo;
    }

}
