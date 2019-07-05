package com.fjut.oj.token.interceptor;

import com.fjut.oj.pojo.TokenModel;
import com.fjut.oj.token.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wyx
 * @Despriction:
 * @Date:Created in 9:08 2019/7/5
 * @Modify By:
 */
@Component
public class CheckUserLoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenManager manager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果不是映射到方法上就直接跳过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CheckUserLogin checkUserLogin = handlerMethod.getMethodAnnotation(CheckUserLogin.class);
        if (null == checkUserLogin) {
            return true;
        }
        // TODO:从头部获取Token
        String auth = request.getParameter("token");
        TokenModel model = manager.getToken(auth);
        if (manager.checkToken(model)) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;

        }
    }

}
