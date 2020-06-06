package com.ncell.wangcai.controller.inputController;

import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.service.input.document.impl.StringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Autowired
    DocumentServiceImpl documentService;
    @Autowired
    StringServiceImpl stringService;


    public InputController() {
    }

    @RequestMapping(value = {""})
    public String input(){
        return "input/show";
    }

    @RequestMapping(value = {"/doc"})
    public String inputDoc(HttpServletRequest req, HttpServletResponse resp, Model model){
        String userInput=req.getParameter("inputtext");
        stringService.obtainData(req);
        stringService.normalizeData();
        stringService.sendData();
        model.addAttribute("inputtext",userInput);
        return "input/doc/show";
    }


}
