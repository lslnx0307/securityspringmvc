package com.lsl.controller;


import com.lsl.model.AuthenticationRequest;
import com.lsl.model.UserDto;
import com.lsl.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + "登陆成功";
    }

    @GetMapping(value = "/loginOut", produces = "text/plain;charset=utf-8")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session) {
        String fullName = "";
        Object o = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (o  == null) {
            fullName = "匿名";
        } else {
            UserDto userDto = (UserDto) o;
            fullName = userDto.getUsername();
        }
        return fullName + "访问的url是：" + "/r/r1";

    }

    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    public String r2(HttpSession session) {
        String fullName = "";
        Object o = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (o  == null) {
            fullName = "匿名";
        } else {
            UserDto userDto = (UserDto) o;
            fullName = userDto.getUsername();
        }
        return fullName + "访问的url是：" + "/r/r2";

    }
}
