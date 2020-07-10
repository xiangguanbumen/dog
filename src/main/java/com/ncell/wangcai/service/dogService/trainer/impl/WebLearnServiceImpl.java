package com.ncell.wangcai.service.dogService.trainer.impl;

import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.dogService.trainer.WebLearnService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @Date 2020/7/9 15:28
 */
@AllArgsConstructor
@Data
@Service("webLearnServiceImpl")
public class WebLearnServiceImpl implements WebLearnService {
    Warehouse warehouse;
    /**
     * 从指定网站学习
     *
     * @param URL
     */
    @Override
    public void learnOneSite(String URL) {

    }

    /**
     * 从全网学习，需要指定开始网页学习
     *
     * @param startURL
     */
    @Override
    public void learnAllSite(String startURL) {

    }
}
