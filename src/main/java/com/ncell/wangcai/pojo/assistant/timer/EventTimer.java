package com.ncell.wangcai.pojo.assistant.timer;

import com.ncell.wangcai.pojo.cns.main.base.Cell;

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
 */
public class EventTimer {



    /**
     * 被注意关注的兴奋事件序列
     * 只要被注意关注就把关注点细胞名称存到序列之中
     */
    ConcurrentLinkedQueue<String> eventQueue = new ConcurrentLinkedQueue<String>();

    /**
     * 细胞遍历周期计数器
     * 当服务将所有的兴奋细胞遍历一周就算一个事件，计数器加一
     */
    long eventCounter = 0;
}
