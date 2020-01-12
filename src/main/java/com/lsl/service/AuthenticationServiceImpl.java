package com.lsl.service;

import com.lsl.model.AuthenticationRequest;
import com.lsl.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Service
public class AuthenticationServiceImpl implements AuthenticationService{


    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {

        if (authenticationRequest == null ||
                StringUtils.isEmpty(authenticationRequest.getUsername()) ||
                StringUtils.isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("参数不能为空");
        }
        UserDto userDto = getUserDto(authenticationRequest.getUsername());
        if (userDto == null) {
            throw new RuntimeException("用户不存在");
        }
        //判断密码是否通过

        return userDto;
    }

    public UserDto getUserDto(String userName) {
        return data.get(userName);
    }


    private Map<String, UserDto> data = new HashMap<>();

    {

        Set<String> author1 = new HashSet<>();
        author1.add("p1");
        Set<String> author2 = new HashSet<>();
        author2.add("p2");
        data.put("zhangsan", new UserDto("1","zhangsan", "123","","", author1));
        data.put("lisi", new UserDto("1","lisi", "456","","", author2));
    }
}
