package com.ncell.wangcai.pojo.cns.common.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

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
     * message+数字序号
     */
    String name;
    /**
     * message的使用者，等同于messageTo，
     * connection是拥有者,等同于connectionFrom
     */
    String user;
    String messageFrom;
    String messageTo;
    int messageType;
    int messageEffectDuration;
    long messageCreatTime;

}
