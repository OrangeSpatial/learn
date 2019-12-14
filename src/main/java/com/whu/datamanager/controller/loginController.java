package com.whu.datamanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){ return "register";}

    @RequestMapping("/retrievePwd")
    public String retrievePwd(){ return "retrievePwd";}

    @RequestMapping("/updatePwd")
    public String updatePwd(){ return "updatePwd";}
}
