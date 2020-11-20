package com.ncell.wangcai.warehouse.product;

import com.ncell.wangcai.pojo.cns.main.part.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 消息仓库
 *
 * @author anliwei
 * @Data 2020/6/7 12:12
 */
@Component("messageWarehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageWarehouse {

    ConcurrentHashMap<String, Message> allMessage = new ConcurrentHashMap(1024000);
    ConcurrentLinkedQueue<String>  messageQueue = new ConcurrentLinkedQueue();
}
