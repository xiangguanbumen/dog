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

    String messageName;
    String messageFrom;
    String messageTo;
    int messageType;
    long messageEffectDuration;
    long messageCreatTime;

}
