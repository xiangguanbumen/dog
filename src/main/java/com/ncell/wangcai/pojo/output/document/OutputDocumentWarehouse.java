package com.ncell.wangcai.pojo.output.document;

import com.ncell.wangcai.pojo.input.document.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输出文档仓库
 * @author anliwei
 * @date 2020年8月2日15:20:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("outputDocumentWarehouse")
public class OutputDocumentWarehouse {


    LinkedBlockingQueue<Document> documentLinkedBlockingQueue = new LinkedBlockingQueue(20480);

}
