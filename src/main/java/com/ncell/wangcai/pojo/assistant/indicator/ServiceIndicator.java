package com.ncell.wangcai.pojo.assistant.indicator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 服务状态指示器
 *
 * 所有的服务发生改变的时候主动汇报状态到这里。
 * 或者是使用一个服务程序去获取所有的其他服务的状态。
 *
 * 所有的需要理解服务状态的服务来这里取各种其他服务的状态。
 *
 * @author anliwei
 * @Date 2020/7/18 17:25
 *
 * @update
 * 2020年8月5日09:17:40
 *
 * 所有的服务发生改变的时候主动汇报状态到这里。
 *
 * 所有的需要理解服务状态的服务来这里取各种其他服务的状态。
 *
 * 方便管理，便于编程
 * 减少对服务状态的读取
 *
 *
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
