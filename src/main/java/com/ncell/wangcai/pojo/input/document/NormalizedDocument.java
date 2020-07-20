package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 文档类型主要是存放字符串数据的标准化结构，Word，ExcelUnit，ppt有对应的软件直接读取
 *
 *
 * @author anliwei
 * @create 2020/6/4 10:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("normalizedDocument")
@Scope("prototype")
public class NormalizedDocument {

    String normalizedDocument;

}
