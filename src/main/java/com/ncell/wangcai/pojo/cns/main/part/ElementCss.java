package com.ncell.wangcai.pojo.cns.main.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 作用相当于空间关系细胞
 * <p>
 * 除细胞外其他神经结构的组成样式，仿照HTML中css的思路，
 * 神经结构的实体组成可以是cell，tissue，agent等实体类，
 * 这些类的组成静态结构通过，elementcss进行控制.
 * 可以控制的element的数量暂时没有想清楚，最好就是上下左右，等几个简单的方向。
 * 与平面渲染不同的是加上了内外等立体概念。
 * 再加上距离的远近。
 * 虽然是多例类，但是描述静态结构的可以数量不多
 *
 * @update
 * 2020年7月13日19:21:51
 * 分别使用笛卡尔坐标和极坐标两个系统来表示位置关系
 *
 * @author anliwei
 * @Date 2020/6/7 11:37
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope("prototype")
public class ElementCss {

    String name;
    String owner;

    ///////////////////////////////
    /////////////方向关系///////////
    //////////////////////////////


    /**
     * 相对方向
     *
     *
     * 因为左右互为相反，
     * 非左即右
     * 本计划只有一个指标，但是存在不在不左不右
     * 同一条横坐标的情况
     * 所以任然使用两个Boolean表示
     *
     * 平面上下关系也是一样
     *
     * 立体高低关系也是一样
     * 因为我们的视觉接收的都是平面图，
     * 所以高低暂时不会使用
     */
    boolean left;
    boolean right;

    boolean up;
    boolean down;

    boolean high;
    boolean low;




    /**
     *
     * 精确方向
     *
     *
     * 两个实体的精确距离，
     * 与下面绝对距离的绝对值是一样的，只不过有正负区分
     * 左右距离
     * 前后距离
     * 上下距离
     */

    int XSpan;
    int YSpan;
    int ZSpan;


    ///////////////////////////////
    /////////////距离关系///////////
    //////////////////////////////

    /**
     * 相对距离
     *
     * 两个实体在视野中的距离关系。
     *
     * 简单粗略的分为
     * 16等分
     * 或是8等分
     * 方便计算
     * 采用三个Boolean值来表示
     * 方便计算机但是不方便人来记忆，
     * 还是采用int来存储
     * 8等级
     * 16个等级，两个系统同时使用
     */

    int roughSpan8;

    int roughSpan16;


    /**
     *
     * 精确距离
     *
     *
     * 两个实体的绝对距离
     * 左右距离
     * 前后距离
     * 上下距离
     *
     * 与上面表示精确方位的距离是一样的，
     * 只是数值全部为正值
     */
    int absoluteXSpan;
    int absoluteYSpan;
    int absoluteZSpan;



    ///////////////////////////////
    /////////极坐标表示位置关系///////
    //////////////////////////////


    /**
     *
     * 相对方向只有上下左右，分的太粗糙了，
     * 可以使用极坐标标记方向
     *
     * 360度
     * 分成12份，每一部分30度
     * 或者15度
     *
     */

    int polarCoordinates12;

    int polarCoordinates24;

    /**
     *
     * 用极坐标系统表示的两个pojo的距离
     *
     * 这个参数可以和xyz坐标共享
     *
     * 一个是粗略的直接距离，
     * 一个是精确的xyz坐标差值
     */




}
