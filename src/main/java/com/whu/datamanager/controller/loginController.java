package com.whu.datamanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

    @RequestMapping("/hello")
    @ResponseBody
    public String login(){
        return "Hello world!!";
    }
}