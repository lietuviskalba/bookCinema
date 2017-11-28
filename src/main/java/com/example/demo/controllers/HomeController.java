package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value={"/","home"})
    public String home(){
        return "home";
    }



    @RequestMapping(value={"/welcome"})
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/admin/booking")
    public String booking(){
        return "booking";
    }


    @RequestMapping(value="/client")
    public String clieny(){
        return "client";
    }

    @RequestMapping(value="/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }


    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}