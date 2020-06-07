package com.ncell.wangcai.controller;

import com.ncell.wangcai.pojo.input.document.NormalizedDocumentModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping(value = {"/testPost"})
    public String testController(HttpServletRequest req){
        String name=req.getParameter("name");
        System.out.println(name);
        return "index";

    }

    @PutMapping(value = {"/testPost"})
    public String testput(@RequestBody NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel) throws InterruptedException {
        String name=normalizedDocumentWarehouseModel.getNormalizedDocumentModeLinkedBlockingQueue().take().getNormalizedDocument();
        System.out.println(name);
        return "index";

    }

}
