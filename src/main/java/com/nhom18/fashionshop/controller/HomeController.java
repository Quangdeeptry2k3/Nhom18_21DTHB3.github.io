package com.nhom18.fashionshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String hello(Model model) {
        return "index";
    }

    @GetMapping("/")
    public String hi(Model model) {
        model.addAttribute("message", "Xin mời đăng nhập!");
        return "home/home";
    }
}
