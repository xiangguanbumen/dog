package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 文档仓库
 * @author anliwei
 * @create 2020/6/4 12:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("documentWarehouse")
public class DocumentWarehouse {

    String name="documentWarehouseModel";
    /**
     * 使用阻塞链表，控制接收的文件数量，文档文件问题不大，但是视频图象文档要注意控制缓存大小
     */
    LinkedBlockingQueue<Document> documentLinkedBlockingQueue = new LinkedBlockingQueue(20480);

}
