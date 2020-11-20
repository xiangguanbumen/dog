package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 文档仓库
 *
 *
 *
 *
 * @author anliwei
 * @create 2020/6/4 12:39
 *
 *
 * @update
 * 2020年8月9日15:59:51
 *
 * 有几种文档分类方法
 * 第一种就是所有的文档，全部使用document来存储
 *
 * 第二种就是分别存储，
 * word excel ppt等
 *
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
