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
     * 以间隔的事件数量来表示两个pojo事件相对时间
     * 用表示时间的事件本身来表示时间间隔。
     *
     * 通过期间细胞兴奋事件数量做间隔
     *
     *
     * 这种兴奋是直接相关细胞。
     *
     * 比如同一时刻兴奋的文字细胞形成的序列
     * 或者是文字细胞的拐地细胞形成的队列
     *
     *  相隔一个细胞兴奋事件
     *
     *  相隔两个细胞兴奋事件
     *
     *  相隔四个事件
     *
     *  相隔八个事件
     *
     *  相隔16个事件
     *
     *  。。。
     *
     *  暂时分为八个等级
     *
     */


    int relatedEventInterval8;


    /**
     *
     * 使用dog系统事件时间
     * 按照全部遍历一次兴奋细胞为次数累积的计时器
     * 全部遍历一次算是一个系统event事件
     *
     * 也暂时分为八个等级
     */

    int systemEventInterval8;

    /**
     *
     * 使用真实时间（经过dog相应比例缩放的
     * 比如1:1024*64）
     * 分为几个等级
     * 分钟，一刻钟，小时，4小时，12小时，24小时，48小时，一周
     *
     * 暂时也分为八个等级
     */

    int systemTimeInterval8;

}
