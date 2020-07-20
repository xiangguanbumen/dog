package com.ncell.wangcai.pojo.assistant.indicator;

import com.ncell.wangcai.service.dogService.threadFactory.MyThreadFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 服务状态指示器
 *
 * @author anliwei
 * @Date 2020/7/18 17:25
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("serviceIndicator")
public class ServiceIndicator {


    int threadNameHashMapState = 0;


    ///////////////////////input服务//////////////////////

    int documentServiceImplState = 0;
    int stringServiceImplState = 0;


    ///////////////////////cns服务//////////////////////

    /**
     * 将文档转换为细胞服务状态
     */
    int documentToCellConvertServiceImplState = 0;

    /**
     * pojo创建服务状态
     */
    int pojoCreatServiceImplState = 0;

    /**
     * pojo发放服务状态
     */
    int pojoImpulseServiceImplState = 0;

    /**
     * pojo状态改变服务状态
     */
    int pojoStateServiceImplState = 0;


    ///////////////////////output服务//////////////////////

}
