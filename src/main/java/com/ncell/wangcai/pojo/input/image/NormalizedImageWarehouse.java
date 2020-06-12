package com.ncell.wangcai.pojo.input.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author anliwei
 * @Data 2020/6/7 9:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("normalizedImageWarehouseModel")
public class NormalizedImageWarehouse {
    /**
     * 容量的由来，人类的视觉系统可以处理的极限是每秒24帧，这里存储48帧是人体极限的两倍，也就是说设置的是2秒以上的视觉暂留
     */
    LinkedBlockingQueue<NormalizedImage> normalizedImageLinkedBlockingQueue = new LinkedBlockingQueue(48);
}
