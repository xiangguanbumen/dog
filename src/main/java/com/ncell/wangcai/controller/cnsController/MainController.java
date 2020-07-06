package com.ncell.wangcai.controller.cnsController;

import com.ncell.wangcai.service.cns.main.physiology.message.impl.MessageSendServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoCreatServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoImpulseServiceImpl;
import com.ncell.wangcai.service.cns.main.physiology.pojo.impl.PojoStateServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anliwei
 * @create 2020/7/6 13:03
 */

@Controller
@RequestMapping("/run")
@Data
@AllArgsConstructor
public class MainController {
    PojoCreatServiceImpl pojoCreatService;
    PojoImpulseServiceImpl pojoImpulseService;
    PojoStateServiceImpl pojoStateService;

    MessageSendServiceImpl messageSendService;

    @RequestMapping(value = {"/doc"})
    public String doDocCellService(){
        pojoCreatService.doCreatService();
        pojoImpulseService.doPojoImpulseService();
        messageSendService.doSendMessageService();
        pojoStateService.doPojoStateService();


        return "redirect:/myinfo";

    }
}
