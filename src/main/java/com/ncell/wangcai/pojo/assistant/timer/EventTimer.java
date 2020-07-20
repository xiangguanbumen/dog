package com.ncell.wangcai.pojo.assistant.timer;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * 事件相关计时器，
 * 根据事件的进展来标定时间。
 * 用拥有时间属性的事件来标定时间
 *
 * 事件本身有时间的绝对定位
 * 比如春晚，十一旅游，吃晚饭，看新闻联播
 * 或者相对定位一节课。一根烟
 *
 * @author anliwei
 * @Date 2020/6/13 9:22
 * @update
 * 2020年7月16日15:56:28
 *
 * @update
 * 2020年7月17日22:25:09
 * 增加一个hashmap存储同一个事件时间内兴奋的细胞名称
 * key用事件开始时间和结束时间命名
 * value存储set集合，值为所有的事件时间段内兴奋的细胞名称
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component("eventTimer")
public class EventTimer {



    /**
     * 被注意关注的兴奋事件序列
     * 只要被注意关注就把关注点细胞名称存到序列之中
     *
     * @update
     * 2020年7月17日22:29:22
     * 事件时间的定义重新订正，
     * 为所有目前兴奋的细胞兴奋一次的时间。
     *
     * 事件时间的名称以事件开始时间和结束时间命名
     * start123456789end987654321
     *
     * @update
     * 2020年7月18日12:14:06
     * 名称不使用结束时间，
     * 因为event时间要全部覆盖整个时间轴
     * 如果有结束的话，就将时间轴分成离散的片段，
     * 使得有些细胞的兴奋不能落到event时间之内。
     *
     * 两个event时间相互接续，第二个的开始就是第一个的结束。
     *
     *
     */
    ConcurrentLinkedQueue<Long> eventQueue = new ConcurrentLinkedQueue<>();

    /**
     * 细胞遍历周期计数器
     * 当服务将所有的兴奋细胞遍历一周就算一个事件，计数器加一
     */
    long eventCounter = 0;

}
