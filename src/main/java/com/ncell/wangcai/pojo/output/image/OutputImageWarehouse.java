package com.ncell.wangcai.pojo.output.image;

import com.ncell.wangcai.pojo.input.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输出图像文件仓库
 *
 * @author anliwei
 * @Date 2020年8月2日15:19:18
 */
@Component("outputImageWarehouse")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OutputImageWarehouse {

    LinkedBlockingQueue<Image> imageLinkedBlockingQueue = new LinkedBlockingQueue(20480);
}
