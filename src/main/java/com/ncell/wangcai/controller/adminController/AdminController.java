package com.ncell.wangcai.controller.adminController;

import com.ncell.wangcai.service.cns.entry.impl.DocumentToCellConvertServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.dogService.trainer.impl.LocalLearnServiceImpl;
import com.ncell.wangcai.service.dogService.trainer.impl.WebLearnServiceImpl;
import com.ncell.wangcai.service.dogService.trainer.impl.StartTrainServiceImpl;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.utils.cns.main.CellUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anliwei
 * @Date 2020/7/9 14:03
 */
@AllArgsConstructor
@Data
@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

    StartTrainServiceImpl startLearnService;

    WebLearnServiceImpl webLearnService;
    LocalLearnServiceImpl localLearnService;

    DocumentToCellConvertServiceImpl documentToCellConvertService;

    DocumentServiceImpl documentService;

    CellUtil cellUtil;

    PojoCreatServiceImpl pojoCreatService;


    /**
     * 跳转控制
     * @return
     */
    @GetMapping(value = {"/study/learnFromTeacher"})
    public String learnFromTeacher(){
        return "admin/study/learnFromTeacher";
    }
    @GetMapping(value = {"/study/learnByMyself"})
    public String learnByMyself(){
        return "admin/study/learnByMyself";
    }

    /**
     * 服务控制
     *
     */


    /**
     * 全部开始
     * @return
     */
    @GetMapping(value = {"/study/doLearnByMyselfFromLocal"})
    public String doLearnByMyselfFromLocal(){
        startLearnService.doStartTrainService();
        return "admin/study/learnByMyself";
    }


    /**
     * 开始单个类型学习
     * @return
     */
    @GetMapping(value = {"/study/doLearnByMyselfFromLocalDoc"})
    public String doLearnByMyselfFromLocalDoc(){

        documentService.doLocalDocumentService();

        try {
            documentToCellConvertService.convertDocToCell();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pojoCreatService.creatPojoByListPojo();

        return "admin/study/learnByMyself";
    }
    @GetMapping(value = {"/study/doLearnByMyselfFromLocalSound"})
    public String doLearnByMyselfFromLocalSound(){
        //todo 声音学习代码
        return "admin/study/learnByMyself";
    }
    @GetMapping(value = {"/study/doLearnByMyselfFromLocalImage"})
    public String doLearnByMyselfFromLocalImage(){
        //todo 图像学习代码
        return "admin/study/learnByMyself";
    }
    @GetMapping(value = {"/study/doLearnByMyselfFromLocalVideo"})
    public String doLearnByMyselfFromLocalVideo(){
        //todo 视频学习代码
        return "admin/study/learnByMyself";
    }

}
