package com.ncell.wangcai.controller;

import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.service.cns.loader.impl.LoadServiceImpl;
import com.ncell.wangcai.service.cns.starter.Impl.StartServiceImpl;
import com.ncell.wangcai.service.cns.stopper.impl.StopServiceImpl;
//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;
    MessageWarehouse messageWarehouse;




    @GetMapping(value = {"/index",""})
    public String index(HttpSession session){

        return "index";

    }

    @GetMapping(value = {"/myadmin"})
    public String admin(){

        return "admin/myadmin";
    }

    @GetMapping(value = {"/myload"})
    public String load(){

        loadService.doLoadService();
        return "redirect:/myinfo";
    }
    @GetMapping(value = {"/mystart"})
    public String start(){

        //startService.doStartService();
        startService.alwaysRun();
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/mystop"})
    public String stop(){

        stopService.doStopService();
        return "redirect:/myinfo";
    }

    @GetMapping(value = {"/myinfo"})
    public String showDogInfo(Model model){

        //获取细胞状态
        int allCellCount = cellWarehouse.getAllCell().size();
        int excitedCellCount = cellWarehouse.getExcitedCell().size();
        int allTextCellCount = cellWarehouse.getTextCell().size();
        int partExcitedCellCount =cellWarehouse.getPartExcitedCell().size();

        //获取连接状态
        int allConnectionCount = connectionWarehouse.getAllConnection().size();

        //获取消息状态
        int allMessageCount = messageWarehouse.getAllMessage().size();

        //添加消息状态
        model.addAttribute("allCellCount",allCellCount);
        model.addAttribute("excitedCellCount",excitedCellCount);
        model.addAttribute("allTextCellCount",allTextCellCount);
        model.addAttribute("partExcitedCellCount",partExcitedCellCount);
        //添加连接状态
        model.addAttribute("allConnectionCount",allConnectionCount);
        //添加消息状态
        model.addAttribute("allMessageCount",allMessageCount);



        return "admin/showdoginfo";
    }

   /* @GetMapping(value = {"/foot"})
    public String foot(){

        return "foot";
    }*/

    @GetMapping(value = {"/debug"})
    public String debug(){

        System.out.println("debug...");
        return "admin/showdoginfo";
    }


}
