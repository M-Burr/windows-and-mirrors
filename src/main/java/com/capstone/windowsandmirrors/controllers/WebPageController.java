package com.capstone.windowsandmirrors.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebPageController {
    @RequestMapping(value = {"/", "/books/**", "/search", "/authors/**"})
    public String index(){
        return "/index.html";
    }
}
