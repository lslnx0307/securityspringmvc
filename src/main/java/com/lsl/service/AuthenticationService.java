package com.lsl.service;

import com.lsl.model.AuthenticationRequest;
import com.lsl.model.UserDto;

public interface AuthenticationService {

    UserDto authentication(AuthenticationRequest authenticationRequest);
}
