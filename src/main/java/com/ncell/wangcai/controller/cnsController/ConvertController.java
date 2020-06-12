package com.ncell.wangcai.controller.cnsController;

import com.ncell.wangcai.service.cns.inputConverter.impl.DocumentToCellConvertServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anliwei
 * @Data 2020/6/7 17:24
 */
@Controller
@RequestMapping("/convert")
@Data
@AllArgsConstructor
public class ConvertController {

    DocumentToCellConvertServiceImpl docCellConvertService;

    @RequestMapping(value = {"/doc"})
    public String convertDocToCell(Model model) throws InterruptedException {
        docCellConvertService.doService();
        String msg="文档已经转化成文档细胞";
        model.addAttribute("msg",msg);
    return "/cns/convert";
    }
}
