package com.ncell.wangcai.service.cns.main.physiology.message;

/**
 *
 * 从消息仓库中所有的消息中挑选可以发放到目标实体的消息，发送到runningMessageCenter
 *
 * @update
 * 2020年7月6日10:01:27
 * 根据先运行再迭代的原则，这个步骤先省略掉
 *
 * @author anliwei
 * @Date 2020/6/20 18:02
 */
public interface MessageSelect {
    /**
     * 执行消息选择的主方法
     */

    public void doSelectService();
    public void SelectMessage();
    /**
     *查找running仓库中实体类
     * @return
     */
    String getRunningPojo();
}
