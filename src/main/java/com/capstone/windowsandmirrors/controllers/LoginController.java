package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.LoginRequest;
import com.capstone.windowsandmirrors.models.LoginResponse;
import com.capstone.windowsandmirrors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/api/login")
    public LoginResponse login(@RequestBody LoginRequest requestData){
        System.out.println(requestData.getUserToken());
        String email = userService.login(requestData.getUserToken());
        return new LoginResponse(email);
    }
}
