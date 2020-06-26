package com.ncell.wangcai.service.cns.main.physiology.message;

/**
 *
 * 从消息仓库中所有的消息中挑选可以发放到目标实体的消息，转存到running消息仓库
 *
 * @author anliwei
 * @Date 2020/6/20 18:02
 */
public interface MessageSelect {
    /**
     * 执行消息选择的主方法
     */
    public void doSelectService();
    /**
     *查找running仓库中实体类
     * @return
     */
    String getRunningPojo();
}
