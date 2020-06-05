package com.ncell.wangcai.controller.inputController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author anliwei
 * @create 2020/6/3 14:22
 */
@Controller("inputSystemController")
@RequestMapping("/input")
public class InputController {

//    @Autowired
//    InputSystemServiceImpl inputSystemServiceImpl;
//    @Autowired
//    ApplicationContextProvider applicationContextProvider;


    public InputController() {
    }

    @RequestMapping(value = {""})
    public String input(){
        return "input/show";
    }

    @RequestMapping(value = {"/doc"})
    public String dogInputDoc(){
        return "input/doc/show";
    }


}
