package com.ncell.wangcai.service.cns.main.physiology.pojo.impl;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.pojo.cns.main.part.Message;
import com.ncell.wangcai.pojo.cns.main.runtime.RunningMessageCenter;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.cns.main.physiology.pojo.PojoImpulseService;
import com.ncell.wangcai.utils.cns.main.ConnectionUtil;
import com.ncell.wangcai.utils.cns.main.MessageUtil;
import com.ncell.wangcai.utils.cns.main.StemUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * pojo的神经冲动发放。
 * 发放之后，这一次的兴奋全部完成，pojo进入不应期。
 * @update
 * 2020年6月24日11:10:38
 * pojo产出的消息不是直接进入目标细胞而是需要先存放到消息仓库，
 * 等待消息选择处理服务，将冗余的消息，相冲突的消息处理后再进行发放。
 * 经过筛选的消息进入，runtime中心，等待发送服务进程来发送消息
 *
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
    RunningMessageCenter runningMessageCenter;

    /**
     * 发送消息到自身的连接结构
     * @update 2020年6月19日16:53:31，生成的细胞，先存放到消息仓库，等待筛选后再调控发放到指定目标。
     * 也就是从直接发放到目标pojo，转换为控制器帮助发放。
     *
     * @param stem
     */
    @Override
    public void fire(Stem stem) {

        Connection connection;
        Message message;
        //如果连接为空。一般应该是新产生的pojo,生成没有目标实体的message并保存到runningMessageCenter。
        if (stem.getConnectionsOutput() == null) {
            //生成没有目标实体的消息并注册到runningMessageCenter
            messageUtil.creatMessageWithoutMessageToAndPutIntoRunningMessageCenterAndMessageWarehouse(stem.getName());

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
                    //2020年6月24日11:13:18暂时将这个方法注释掉，所有的消息存放的消息仓库，经过筛选后进入下一关
                    //根据连接查找，连接到的实体类并将message名称字符串添加到messagesInput
                   // stemUtil.findStemByName(connection.getConnectionTo()).getMessagesInput().add(message.getName());
                }

            }
        }
    }
}
