package com.ncell.wangcai.service.cns.main.physiology.impl;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.pojo.cns.main.part.Message;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.PojoImpulseService;
import com.ncell.wangcai.utils.cns.main.ConnectionUtil;
import com.ncell.wangcai.utils.cns.main.MessageUtil;
import com.ncell.wangcai.utils.cns.main.StemUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * pojo的神经冲动发放。
 * 发放之后，这一次的兴奋全部完成，pojo进入不应期。
 *
 * @author anliwei
 * @Date 2020/6/13 22:30
 */
@Component("pojoImpulseServiceImpl")
@NoArgsConstructor
@AllArgsConstructor
public class PojoImpulseServiceImpl implements PojoImpulseService {

    Warehouse warehouse;
    ConnectionWarehouse connectionWarehouse;
    MessageWarehouse messageWarehouse;
    StemUtil stemUtil;
    MessageUtil messageUtil;
    ConnectionUtil connectionUtil;

    /**
     * 发送消息到自身的连接结构
     *
     * @param stem
     */
    @Override
    public void fire(Stem stem) {

        Connection connection;
        Message message;
        //如果连接为空。一般应该是新产生的pojo
        if (stem.getConnectionsOutput() == null) {

        }
        //如果连接不为空
        else {
            //遍历连接索引
            for (String connectionName : stem.getConnectionsOutput()) {
                //根据索引查找 connection实例
                connection = connectionWarehouse.getAllConnection().get(connectionName);
                //如果连接不为空
                if (connection != null) {
                    //更新connection
                    connectionUtil.connectionUpdateAfterUsed(connection);
                    //生成message并注册到仓库
                    message = messageUtil.creatMessageAndPutIntoMessageWarehouse(connection.getConnectionFrom(), connection.getConnectionTo());
                    //根据连接查找，连接到的实体类并将message名称字符串添加到messagesInput
                    stemUtil.findStemByName(connection.getConnectionTo()).getMessagesInput().add(message.getName());
                }

            }
        }
    }
}
