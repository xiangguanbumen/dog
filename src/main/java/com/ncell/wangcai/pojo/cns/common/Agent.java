package com.ncell.wangcai.pojo.cns.common;

import com.ncell.wangcai.pojo.cns.common.part.ConnectionsInModel;
import com.ncell.wangcai.pojo.cns.common.part.ElementCss;
import com.ncell.wangcai.pojo.cns.common.part.ElementJs;
import com.ncell.wangcai.pojo.cns.common.part.MessageInModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;

/**
 * @author anliwei
 * @Data 2020/6/7 12:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Scope("prototype")
public class Agent {

    String name = "";
    /**
     * 类型，0表示实体，1表示关系
     */
    int type = 0;

    /**
     * 用0表示静息，1表示兴奋
     */
    int currentState = 0;

    /**
     * 绝对时间
     */
    long currentStateStartTime;

    /**
     * 状态持续时间
     */
    long excitedStateDuration;

    /**
     * 不应期持续时间
     */
    long refractoryPeriod;

    /**
     * 连接
     */
    ConnectionsInModel connectionsInModel;

    /**
     * 消息
     */
    MessageInModel messageInModel;

    /**
     * 组成元素
     */
    HashSet<String> elementsInModel;

    /**
     * 元素静态组合
     */
    ElementCss elementCSS;

    /**
     * 元素动态组合
     */

    ElementJs elementJS;

}
