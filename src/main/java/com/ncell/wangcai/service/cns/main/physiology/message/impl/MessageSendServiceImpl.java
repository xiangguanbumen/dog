package com.ncell.wangcai.service.cns.main.physiology.message.impl;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.part.Message;
import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import com.ncell.wangcai.service.cns.main.physiology.message.MessageSendService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * 将消息仓库中的消息发送到消息的接收细胞
 *
 * @author anliwei
 * @create 2020/7/6 10:02
 */
@Data
@AllArgsConstructor
@Service("messageSendImpl")
public class MessageSendServiceImpl implements MessageSendService {

    MessageWarehouse messageWarehouse;
    CellWarehouse cellWarehouse;

    /**
     * 遍历消息仓库，根据消息的内容，将消息仓库中的消息发送到消息的接收细胞
     *
     *
     * @update
     * 2020年8月5日18:06:43
     * 是否增加一个默认接受消息的类，
     * 可以是多个，不同的层级有一个默认接受类
     * 好处就是，当同一批兴奋的细胞有一个同一的接受站，
     * 便于新细胞的生成。
     *
     */

    @Override
    public void doSendMessageService() {
        //遍历所有消息
        while(!messageWarehouse.getMessageQueue().isEmpty()){
            String messageName=messageWarehouse.getMessageQueue().poll();
            if(messageWarehouse.getAllMessage().get(messageName)!=null){
                Message message=messageWarehouse.getAllMessage().get(messageName);
                //获取消息目的细胞
                String cellToName=message.getMessageTo();
                Cell cellTo = cellWarehouse.getAllCell().get(cellToName);
                //添加消息到目的细胞
                cellTo.getMessagesInput().add(messageName);
                //将细胞添加到状态部分改变队列
                cellWarehouse.getPartExcitedCell().offer(cellToName);

            };
        }
    }
}
