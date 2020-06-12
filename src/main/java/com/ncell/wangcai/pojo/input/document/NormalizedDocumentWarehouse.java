package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author anliwei
 * @create 2020/6/4 12:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("normalizedDocumentWarehouse")
public class NormalizedDocumentWarehouse {

    String name="normalizedDocumentWarehouseModel";

    /**
     * 使用阻塞链表，控制接收的文件数量，文档文件问题不大，但是视频图象文档要注意控制缓存大小
     * JAVA中此队列的默认和最大长度为 Integer.MAX_VALUE。此队列按照先进先出的原则对元素进行排序
     * 此处使用16，没有任何依据，以后根据实际需要修改
     *
     */
    LinkedBlockingQueue<NormalizedDocument> normalizedDocumentLinkedBlockingQueue = new LinkedBlockingQueue(16);



}
