package com.ncell.wangcai.controller;

import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.service.cns.starter.Impl.StartServiceImpl;
import com.ncell.wangcai.service.cns.stopper.impl.StopServiceImpl;
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


    StartServiceImpl startService;
    StopServiceImpl stopService;
    CellWarehouse cellWarehouse;




    @GetMapping(value = {"/index",""})
    public String index(HttpSession session){

        return "index";

    }

    @GetMapping(value = {"/myadmin"})
    public String admin(){

        return "myadmin";
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

    @GetMapping(value = {"/myinfo"})
    public String showDogInfo(Model model){

        int allCellCount = cellWarehouse.getAllCell().size();

        model.addAttribute("allCellCount",allCellCount);
        return "showdoginfo";
    }

    @GetMapping(value = {"/foot"})
    public String foot(){

        return "foot";
    }



}
