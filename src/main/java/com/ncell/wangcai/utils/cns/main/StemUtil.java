package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.part.ElementJs;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * @author anliwei
 * @Date 2020/6/14 21:56
 */
@AllArgsConstructor
@Data
@Component("stemUtil")
public class StemUtil {

    //todo 消息时效性的判断方法
    /**
     * 对message的总的判断
     *
     * @param stem
     * @return
     */
   public boolean messageJudge(Stem stem){
        return this.messageEnough(stem) && this.messageSequenceRight(stem) && this.messageLocationRight(stem);
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
}
