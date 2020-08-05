package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 连贯性细胞
 * 描述两个细胞之间的连贯性，
 * 特别是文字细胞。
 * 注意与细胞组成部分connection的区别。
 * connection是细胞的一部分，是细胞的固有属性，是固定的。
 * coherenceCell是使用细胞来表示，两个或多个实体的连接关系，是临时的。
 *
 * @author anliwei
 * @Date 2020/8/4 20:14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class CoherenceCell extends Cell {

    /**
     * 根据细胞自身connection确定连贯性绝对值
     *
     * 根据绝对值分为不同的等级
     *
     *
     */
}
