package com.ncell.wangcai.pojo.input.sound;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 声音仓库
 * @author anliwei
 * @Date 2020/7/16 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("soundWarehouse")
public class SoundWarehouse {
    LinkedBlockingQueue<Sound> soundLinkedBlockingQueue = new LinkedBlockingQueue(20480);
}
