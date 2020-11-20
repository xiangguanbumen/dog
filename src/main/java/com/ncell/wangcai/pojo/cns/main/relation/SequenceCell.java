package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 时间相关细胞
 * 序列细胞，
 * 只关心事件的先后顺序。

 * @author anliwei
 * @date 2020/7/13 14:57
 *  当有单个pojo兴奋时，静息时；
 *  （单个细胞暂时不考虑）
 *  或是两个pojo先后兴奋，先后静息。
 *  一个静息一个兴奋，
 *  一个兴奋一个静息
 *  等四种情况时
 *  分为几类不同的时间细胞
 *
 *  继承自stem。
 *  不同的event细胞的变化主要是
 *  elementJS的变化
 *
 * @update
 * 2020年8月4日20:55:09
 *
 * 关系细胞中的时间或者其他成队列排列的两个实体的关系
 *
 *
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class SequenceCell extends Cell {

    /**
     * 将先后顺序分为，不同的等级，
     * 最简单的就是先后，
     *
     * 把句子或者事件分成几个部分，
     * 确定不同的部分之间的间隔，
     * 比如分成前中后三部分，
     * 第一部分和第三部分的关系
     */
    int level2class;

    int level3class;

    int level4class;

    int level9class;


}
