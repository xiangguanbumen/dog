package com.ncell.wangcai.pojo.cns.main.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 具体的消息类，在agent，tissue，细胞，scene，story之间传递消息
 *
 * @author anliwei
 * @Data 2020/6/7 10:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Message {

    /**
     * message+@+到达那里+系统当前时间
     */
    String name;
    /**
     * message的使用者，等同于messageTo，
     * connection是拥有者,等同于connectionFrom
     */
    String user;
    String messageFrom;
    String messageTo;
    /**
     * 消息类型，默认普通消息，int值设为1
     */
    int messageType;
    /**
     * 消息的有效期
     *  默认设置5000毫秒（没有依据自己估计得）
     */

    int messageEffectDuration=5000;
    long messageCreatTime;

}
