package com.ncell.wangcai.controller.inputController;

import com.ncell.wangcai.pojo.input.document.Document;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.service.input.document.impl.StringServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author anliwei
 * @create 2020/6/3 14:22
 */
@Controller("inputController")
@RequestMapping("/input")
@AllArgsConstructor
public class InputController {

    DocumentServiceImpl documentService;
    StringServiceImpl stringService;
    Document document;
    DocumentWarehouse documentWarehouse;

    //todo 有参构造可以使用，如果加上无参的话，类内部参数无法自动注入。需要深入理解spring原理

    private static final Logger LOGGER = LoggerFactory.getLogger(InputController.class);

    @RequestMapping(value = {""})
    public String input(){
        return "input/show";
    }

    @RequestMapping(value = {"/doc"})
    public String inputDoc(HttpServletRequest req, HttpServletResponse resp, Model model){
        return "input/doc/show";
    }

    /**
     * 处理输入框文字
     * @param req
     * @param resp
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = {"/doc/string"})
    public String inputDocString(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException {
        String userInput=req.getParameter("inputtext");
        document.setStringDocument(userInput);
        documentWarehouse.getDocumentLinkedBlockingQueue().put(document);
       // stringService.doService();
        return "redirect:/convert/doc";

    }

    /**
     * 处理上传文档
     * @param req
     * @param resp
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = {"/doc/file"})
    public String inputDocFile(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException {
        String userInput=req.getParameter("inputtext");
        document.setStringDocument(userInput);
        documentWarehouse.getDocumentLinkedBlockingQueue().put(document);
        stringService.doService();
        return "redirect:/convert/doc";

    }



    /**
     * 跳转到文件选择页面
     */

    @RequestMapping(value = {"/uploadfile"})
    public String inputUploadFile(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException {
        return "/input/uploadfile";
    }


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "c://ncell//upload//";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //LOGGER.info("上传成功");
        return "上传成功";
       // return "上传失败！";
    }


}
