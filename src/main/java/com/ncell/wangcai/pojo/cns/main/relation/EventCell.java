package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 事件细胞，
 * 强关系细胞。
 * 事件细胞一定有兴奋性的变化。
 * 关系细胞未必有兴奋性的变化。
 *
 *
 * 与elementJs区别。
 * eventCell是没有存储的elementJs
 * 存储到细胞
 *
 * @author anliwei
 * @Date 2020/8/5 21:45
 */

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class EventCell extends Cell {

    /**
     * 单个细胞的兴奋与静息
     * 两个细胞的兴奋与静息变化
     * 三个细胞的兴奋与静息变化
     * 一组细胞的兴奋与静息
     *
     * 两个事件之间的间隔
     * 没有事件也是一种事件
     *
     * 静息事件
     */
}
