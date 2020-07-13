package com.ncell.wangcai.pojo.cns.main.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 作用相当于时间关系细胞
 * <p>
 * 除细胞外其他神经结构的组成样式，仿照HTML中js的思路，
 * 神经结构的实体组成可以是cell，tissue，agent等实体类，
 * 这些类的组成动态结构通过，elementjs进行控制.
 * 可以控制的element的数量暂时没有想清楚，最好就是先后等时间概念
 * 再加上时间距离的的长短。
 *
 *
 * @update
 * 2020年7月13日16:39:36
 * 添加具体内容，时间只有一个维度。
 * 但是又先后，仍然需要两个量来表示。
 *
 * @author anliwei
 * @Date 2020/6/7 11:38
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope("prototype")
public class ElementJs {

    String name;
    String owner;


    /**
     * 时间先后
     */
    boolean before;
    boolean after;


    /**
     * 事件相对时间
     *
     * 通过期间细胞兴奋事件数量做间隔
     *
     * 分为几个等级
     * 分钟， 小时
     * 马上，立刻，一会儿，好久
     *
     *  相隔一个事件
     *
     *  相隔两个事件
     *
     *  相隔四个事件
     *
     *  相隔八个事件
     *
     *  相隔16个事件
     *
     */



}
