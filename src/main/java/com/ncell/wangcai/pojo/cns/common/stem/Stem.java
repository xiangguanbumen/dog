package com.ncell.wangcai.pojo.cns.common.stem;

import com.ncell.wangcai.pojo.cns.common.part.ElementCss;
import com.ncell.wangcai.pojo.cns.common.part.ElementJs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author anliwei
 * @create 2020/6/8 14:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class Stem {
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
     * 输入连接
     */
    HashSet<String> connectionsInput;

    /**
     * 输出连接
     */

    HashSet<String> connectionsOutput;


    /**
     * 输出消息
     */

    LinkedList<String> messagesOutput ;

    /**
     * 输入消息
     */
    LinkedList<String> messagesInput ;

    /**
     * 组成元素,使用元素的名称，需要的时候根据元素名称到仓库去取
     */
    HashSet<String> elements;

    /**
     * 元素静态组合
     */
    ElementCss elementCSS;

    /**
     * 元素动态组合
     */

    ElementJs elementJS;
}
