package com.ncell.wangcai.pojo.output.sound;


import com.ncell.wangcai.pojo.input.sound.Sound;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输出声音仓库
 * @author anliwei
 * @Date 2020年8月2日15:17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("outputSoundWarehouse")
public class OutputSoundWarehouse {
    LinkedBlockingQueue<Sound> soundLinkedBlockingQueue = new LinkedBlockingQueue(20480);
}
