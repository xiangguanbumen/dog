package com.ncell.wangcai.controller.inputController;

import com.ncell.wangcai.pojo.input.document.DocumentModel;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouseModel;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.service.input.document.impl.StringServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@Controller("inputController")
@RequestMapping("/input")
@NoArgsConstructor
@AllArgsConstructor
public class InputController {

    @Autowired
    DocumentServiceImpl documentService;
    @Autowired
    StringServiceImpl stringService;
    @Autowired
    DocumentModel documentModel;
    @Autowired
    DocumentWarehouseModel documentWarehouseModel;


    @RequestMapping(value = {""})
    public String input(){
        return "input/show";
    }

    @RequestMapping(value = {"/doc"})
    public String inputDoc(HttpServletRequest req, HttpServletResponse resp, Model model){
        return "input/doc/show";
    }

    @RequestMapping(value = {"/doc/string"})
    public String inputDocString(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException {
        String userInput=req.getParameter("inputtext");
        documentModel.setStringDocument(userInput);
        documentWarehouseModel.getDocumentModelLinkedBlockingQueue().put(documentModel);
        stringService.doService();
        return "redirect:/convert/doc";

    }

}
