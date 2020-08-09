package com.ncell.wangcai.pojoruntime.input.document;

/**
 * 文档处理车间
 * 提供文档处理过程中产生的中间的各种类的临时存储结构。中间类存储
 *
 * @author anliwei
 * @Date 2020/8/9 11:22
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("documentWorkshop")
public class DocumentWorkshop {
    String name = "documentWorkshop";


}
