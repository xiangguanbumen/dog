package com.ncell.wangcai.controller.cnsController;

import com.ncell.wangcai.service.cns.converter.impl.DocCellConvertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author anliwei
 * @Data 2020/6/7 17:24
 */
@Controller
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    DocCellConvertServiceImpl docCellConvertService;

    @RequestMapping(value = {"/doc"})
    public String convertDocToCell() throws InterruptedException {
        docCellConvertService.doService();
    return "/cns/convert";
    }
}
