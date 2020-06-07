package com.ncell.wangcai.pojo.cns.common;

import com.ncell.wangcai.pojo.cns.common.part.ConnectionsInModel;
import com.ncell.wangcai.pojo.cns.common.part.MessageInModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * @author anliwei
 * @Data 2020/6/7 9:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Scope("prototype")
public class Cell {


    String name = "";
    /**
     * 类型，0表示实体，1表示关系
     */
    int type = 0;

    /**
     *用0表示静息，1表示兴奋
     */
    int currentState = 0;

    /**
     * 绝对时间
     */
    long currentStateStartTime;

    /**
     * 兴奋状态持续时间,默认持续5000毫秒
     */
    long excitedStateDuration=5000;

    /**
     * 不应期持续时间，默认没有不应期
     */
    long refractoryPeriod =0 ;

    /**
     * 连接
     */
    ConnectionsInModel connectionsInModel;

    /**
     * 消息
     */
    MessageInModel messageInModel;

}
