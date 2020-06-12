package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 10:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("normalizedDocumentModel")
@Scope("prototype")
public class NormalizedDocument {

    String normalizedDocument;

}
