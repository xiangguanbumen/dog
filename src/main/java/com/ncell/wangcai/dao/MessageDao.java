package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.part.Message;

/**
 * @author anliwei
 * @create 2020/6/9 11:16
 */
public interface MessageDao {
    /**
     * @param message
     * @return
     */
   int addMessage(Message message);

    /**
     * 通过名称查找message
     * @param messageName
     * @return
     */
   Message findMessage(String messageName);

    /**
     * 删除message
     * @param messageName
     * @return
     */
   int deleteMessage(String messageName);
}
