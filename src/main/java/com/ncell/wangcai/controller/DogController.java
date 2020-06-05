package com.ncell.wangcai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author anliwei
 * @create 2020/6/3 10:02
 */
@Controller
@RequestMapping("/")
public class DogController {


    @GetMapping(value = {"/index",""})
    public String webdogMainController(HttpSession session){


        return "index";

    }


}
