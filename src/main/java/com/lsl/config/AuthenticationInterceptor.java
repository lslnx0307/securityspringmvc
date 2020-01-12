package com.lsl.config;

import com.lsl.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *     权限拦截器
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session = request.getSession();
        Object o = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (o == null) {
            writeCotext(response, "请登录");
        }
        UserDto userDto = (UserDto) o;
        //获取请求的地址
        String requestURI = request.getRequestURI();
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("/r1")) {
            return true;
        }
        if (userDto.getAuthorities().contains("p2") && requestURI.contains("/r2")) {
            return true;
        }

        writeCotext(response, "权限不足，拒绝访问");
        return false;
    }

    private void writeCotext(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(msg);
        writer.close();
    }
}
