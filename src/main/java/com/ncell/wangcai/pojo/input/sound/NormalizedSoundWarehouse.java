package com.ncell.wangcai.pojo.input.sound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 标准化后声音仓库
 * @author anliwei
 * @Date 2020/7/16 15:28
 */
@Component("normalizedSoundWarehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NormalizedSoundWarehouse {

    LinkedBlockingQueue<NormalizedSound> normalizedSoundLinkedBlockingQueue = new LinkedBlockingQueue(20480);
}
