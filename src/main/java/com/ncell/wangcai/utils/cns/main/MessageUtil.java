package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.part.ElementJs;
import com.ncell.wangcai.pojo.cns.main.part.Message;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.MessageWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * 消息处理工具类
 *
 * @author anliwei
 * @Date 2020/6/14 21:56
 */
@AllArgsConstructor
@Data
@Component("messageUtil")
public class MessageUtil {

    MessageWarehouse messageWarehouse;

    /**
     * 对message总的判断
     *
     * @param stem
     * @return
     */
   public boolean messageJudge(Stem stem){
       //首先判断消息是否有效
       this.messageAlive(stem);
       //判断消息是否足以激活pojo
        return this.messageEnough(stem) && this.messageSequenceRight(stem) && this.messageLocationRight(stem);
    }

    void messageAlive(Stem stem){
        Message message;
        //依次遍历所有message索引
        for (String messageName :
                stem.getMessagesInput() ) {
            message=messageWarehouse.getAllMessage().get(messageName);
            //如果message不为空
            if(message!=null){
                //如果产生时间加上有效期大于现在的时间则，消息无效
                if(message.getMessageCreatTime()+message.getMessageEffectDuration()>System.currentTimeMillis()){
                    //从索引中去除
                    stem.getMessagesInput().remove(messageName);
                }
            }

        }

    }

    /**
     * 判断包含的消息是否足够
     *
     * @param stem
     * @return
     */
    boolean messageEnough(Stem stem) {
        return stem.getMessagesInput().containsAll(stem.getElements());
    }

    /**
     * 判断包含的消息时间顺序是否正确
     * 只要包含所有的序列细胞就可以
     *
     * @param stem
     * @return
     */
   boolean messageSequenceRight(Stem stem) {
        return canGenerateAllJs(stem.getMessagesInput(), stem.getElementJS());
    }

    /**
     * 判断包含的消息位置关系是否正确
     * @param stem
     * @return
     */

     boolean messageLocationRight(Stem stem){
        return true;
    }

    /**
     * 能否生成序列
     * @param messagesInput
     * @param elementJs
     * @return
     */

     boolean canGenerateAllJs(LinkedList<String> messagesInput, ElementJs elementJs){
        //todo 详细方法待完善，逐个对比序列细胞，在message中查看，是否可以依次生成。队列细胞。
        return messagesInput.contains(elementJs.toString());
    }

    /**
     * 产生消息实体，注册到仓库
     * @param messageFrom
     * @param messageTo
     * @return
     */
    public Message creatMessageAndPutIntoMessageWarehouse(String messageFrom,String messageTo){
        Message message= this.creatMessage(messageFrom,messageTo);
         this.putIntoMessageWarehouse(message);
         return message;
    }

    /**
     * 产生新的消息实体
     * @param messageFrom
     * @param messageTo
     * @return
     */
     Message creatMessage(String messageFrom,String messageTo){
         Message message=new Message();
         message.setName("message@"+messageTo+Long.toString(System.currentTimeMillis()));
         message.setUser(messageTo);
         message.setMessageFrom(messageFrom);
         message.setMessageTo(messageTo);
         message.setMessageCreatTime(System.currentTimeMillis());
         return message;
    }

    /**
     *  将message实体添加到，message仓库
     */

    void putIntoMessageWarehouse(Message message){
        messageWarehouse.getAllMessage().put(message.getName(),message);
    }

}
