package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.LoginRequest;
import com.capstone.windowsandmirrors.models.User;
import com.capstone.windowsandmirrors.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UsersService userService;
    @PostMapping("/api/login")
    public User login(@RequestBody LoginRequest requestData){
        //System.out.println(requestData.getUserToken());
        User user = userService.login(requestData.getUserToken());
        return user;
    }
}
