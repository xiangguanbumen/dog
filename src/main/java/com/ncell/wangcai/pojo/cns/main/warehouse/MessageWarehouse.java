package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.part.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

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
}
