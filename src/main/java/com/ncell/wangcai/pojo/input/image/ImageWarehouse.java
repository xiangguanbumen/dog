package com.ncell.wangcai.pojo.input.image;

import com.ncell.wangcai.pojo.input.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 图像文件仓库
 *
 * @author anliwei
 * @Date 2020/7/16 15:19
 */
@Component("imageWarehouse")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImageWarehouse {

    LinkedBlockingQueue<Image> imageLinkedBlockingQueue = new LinkedBlockingQueue(20480);
}
