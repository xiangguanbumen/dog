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
 * @author anliwei
 * @Data 2020/6/7 11:38
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Scope("prototype")
public class ElementJs {

    String name;
    String owner;
}
