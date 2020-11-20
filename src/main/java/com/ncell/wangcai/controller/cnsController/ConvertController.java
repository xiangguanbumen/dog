package com.ncell.wangcai.controller.cnsController;

import com.ncell.wangcai.service.cns.entry.document.impl.DocumentToCellConvertServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anliwei
 * @Date 2020/6/7 17:24
 */
@Controller
@RequestMapping("/convert")
@Data
@AllArgsConstructor
public class ConvertController {

    DocumentToCellConvertServiceImpl documentToCellConvertService;

    @RequestMapping(value = {"/doc"})
    public String convertDocToCell(Model model) throws InterruptedException {
        documentToCellConvertService.doService();
        String msg="文档已经转化成文档细胞";
        model.addAttribute("msg",msg);
        return "/cns/convert";
       // return "redirect:/run/doc";
    }
}
