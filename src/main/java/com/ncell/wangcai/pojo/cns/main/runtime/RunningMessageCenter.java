package com.ncell.wangcai.pojo.cns.main.runtime;


import com.ncell.wangcai.pojo.cns.main.part.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 运行时消息中心，
 * 负责接收所有消息的备份，此时的备份只是备份发送方
 * 处理不知道像哪里发送的消息
 * @author anliwei
 * @Date 2020/6/11 20:53
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Component("runningMessageCenter")
public class RunningMessageCenter {
    /**
     * 第一个string保存产生消息的pojo的名称，第二个String保存没有目的地消息名称
     */
    ConcurrentHashMap<String, String> messageInRunningMessageCenter = new ConcurrentHashMap(1024000);
}
