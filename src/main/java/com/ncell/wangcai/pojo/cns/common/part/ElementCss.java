package com.ncell.wangcai.pojo.cns.common.part;

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
 * @author anliwei
 * @Data 2020/6/7 11:37
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope("prototype")
public class ElementCss {

    String name;

}
