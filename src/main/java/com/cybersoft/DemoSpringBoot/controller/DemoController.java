package com.cybersoft.DemoSpringBoot.controller;

import com.cybersoft.DemoSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller => dung de viet web dang fe, be chung mot project
//@RestController => dung de viet dang back end
//@ResponseBody => chi tra chuoi khong tra ra giao dien

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    User user;

    @GetMapping("/hello")
    public String hello() {
        return "Hello demo spring " + user.getFullName();
    }

    @PostMapping("/hello-post")
    public String helloPost() {
        return "";
    }
}
