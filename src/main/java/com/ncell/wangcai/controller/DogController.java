package com.ncell.wangcai.controller;

import com.ncell.wangcai.pojo.assistant.indicator.CnsIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.InputIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.OutputIndicator;
import com.ncell.wangcai.pojo.assistant.indicator.ServiceIndicator;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.dogService.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.service.dogService.manager.impl.ManagerServiceImpl;
import com.ncell.wangcai.service.dogService.starter.Impl.StartServiceImpl;
import com.ncell.wangcai.service.dogService.stopper.impl.StopServiceImpl;
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.ncell.wangcai.service.dogService.trainer.impl.StartTrainServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    LoadServiceImpl loadService;
    StartServiceImpl startService;
    StopServiceImpl stopService;
    StartTrainServiceImpl startTrainService;

    ManagerServiceImpl managerService;

    CnsIndicator cnsIndicator;
    InputIndicator inputIndicator;
    OutputIndicator outputIndicator;
    ServiceIndicator serviceIndicator;


    /**
     * input部分
     */

    DocumentWarehouse documentWarehouse;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;

    /**
     * cns部分
     */
    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;
    MessageWarehouse messageWarehouse;






    @GetMapping(value = {"/index",""})
    public String index(HttpSession session){

        return "index";

    }


    @GetMapping(value = {"/admin"})
    public String admin(){

        return "admin/admin";
    }

    @GetMapping(value = {"/myload"})
    public String load(){

        loadService.doLoadService();
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/mystart"})
    public String start(){
        startService.doStartService();

        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/mystop"})
    public String stop(){

        stopService.doStopService();
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/mymanager"})
    public String manager(){

        managerService.doService();
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/mytrain"})
    public String train(){
        System.out.println(" startTrainService.doStartTrainService();"+System.currentTimeMillis());
        startTrainService.doStartTrainService();

        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/myinfo"})
    public String showDogInfo(Model model){

        ///////////////第一部分获取输入部分信息/////////////////

        int documentCount = documentWarehouse.getDocumentLinkedBlockingQueue().size();
        int normalizedDocumentCount = normalizedDocumentWarehouse.getNormalizedDocumentLinkedBlockingQueue().size();

        ///////////////第二部分获取cns部分信息/////////////////
        //获取细胞状态
        int allCellCount = cellWarehouse.getAllCell().size();
        int excitedCellCount = cellWarehouse.getExcitedCell().size();
        int allTextCellCount = cellWarehouse.getTextCell().size();
        int partExcitedCellCount =cellWarehouse.getPartExcitedCell().size();

        //获取连接状态
        int allConnectionCount = connectionWarehouse.getAllConnection().size();

        //获取消息状态
        int allMessageCount = messageWarehouse.getAllMessage().size();


        ///////////////第三部分获取输出部分信息/////////////////


        ///////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////
        //通过indicator来传递信息

        model.addAttribute("cnsIndicator",cnsIndicator);
        model.addAttribute("inputIndicator",inputIndicator);
        model.addAttribute("outputIndicator",outputIndicator);
        model.addAttribute("serviceIndicator",serviceIndicator);


        //添加消息状态
        model.addAttribute("allCellCount",allCellCount);
        model.addAttribute("excitedCellCount",excitedCellCount);
        model.addAttribute("allTextCellCount",allTextCellCount);
        model.addAttribute("partExcitedCellCount",partExcitedCellCount);
        //添加连接状态
        model.addAttribute("allConnectionCount",allConnectionCount);
        //添加消息状态
        model.addAttribute("allMessageCount",allMessageCount);

        //添加input信息
        model.addAttribute("documentCount",documentCount);
        model.addAttribute("normalizedDocumentCount",normalizedDocumentCount);



        return "admin/doginfo";
    }


    @GetMapping(value = {"/debug"})
    public String debug(){

        System.out.println("debug...");
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/about"})
    public String about(){

        return "/about";
    }

}
