package com.ncell.wangcai.controller;

import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import com.ncell.wangcai.service.cns.starter.Impl.StartServiceImpl;
import com.ncell.wangcai.service.cns.stopper.impl.StopServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author anliwei
 * @create 2020/6/3 10:02
 */
@Controller("dogController")
@Data
@AllArgsConstructor
@RequestMapping("/")
public class DogController {


    StartServiceImpl startService;
    StopServiceImpl stopService;

    @GetMapping(value = {"/index",""})
    public String index(HttpSession session){

        return "index";

    }


    @GetMapping(value = {"/start"})
    public String start(){

        startService.loadCell();
        return "index";
    }

    @GetMapping(value = {"/stop"})
    public String stop(){

        stopService.saveCell();
        return "index";
    }

}
