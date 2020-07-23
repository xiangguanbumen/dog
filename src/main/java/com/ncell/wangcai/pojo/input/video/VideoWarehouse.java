package com.ncell.wangcai.pojo.input.video;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author anliwei
 * @Date 2020/7/16 15:29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("videoWarehouse")

public class VideoWarehouse {
    LinkedBlockingQueue<Video> videoLinkedBlockingQueue = new LinkedBlockingQueue(1024);
}
