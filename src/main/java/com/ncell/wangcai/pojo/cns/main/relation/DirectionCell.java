package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 位置相关细胞
 * 位置关系细胞
 *
 * 关系细胞要配合注意来确定，不同的注意焦点下，关系细胞就会发生改变。
 *
 * 根据两个细胞的位置来激活
 * 大概分为360种
 * 简单的分为四种，或八种
 *
 * 更加复杂的就是，
 * 横坐标差距除以纵坐标的插件
 * 或者相反
 *
 * 此处规定统一使用tan至来表示。
 * 不使用sin是因为要计算斜边多一步计算。
 * 而且tan分别的比较分散。
 *
 *
 * 继承自stem。
 * 不同的位置关系细胞的变化主要是
 * elementCSS的变化
 * @author anliwei
 * @date 2020/7/13 15:07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class DirectionCell extends Cell {
    /**
     * 360度
     * 分成12份，每一部分30度
     * 或者分成24份，每一部分15度
     *
     */

    int polarCoordinates12;

    int polarCoordinates24;
}
