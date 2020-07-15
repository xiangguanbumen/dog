package com.ncell.wangcai.pojo.assistant.timer;

/**
 *
 * 旺财系统内部时间
 *
 * @author anliwei
 * @Date 2020/6/13 9:22
 */
public class DogSystemTimer {
    /**
     *
     * 方案一
     * dog系统时间暂时设定为跟真实时间成比例的时间，
     * 比如真实时间除以1024.
     * dog世界的一秒等于外面的1024秒。或者1024*64秒
     * 使用移位运算，方便快速。
     *
     * 方案二
     * 使用状态改变或者细胞发放服务遍历一次所有兴奋细胞为周期。
     * 每次启动从零开始
     *
     *
     * 实际中可以两种方案同时使用。
     *
     */

    long dogSystemTime=0;
}
