package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 9:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("document")
@Scope("prototype")
public class Document {

    //需要引入poi相关资料，进行Word，Excel等格式的解析,
    /**
     * 接收Word格式文档文件
     */
    Object word=null;

    /**
     * 接收Excel格式文档文件
     */
    Object excel=null;
    /**
     * 接收PPT格式文档文件
     */
    Object ppt=null;
    /**
     * 接收txt格式文档文件
     */
    Object txt=null;

    /**
     * 接收string格式文档文件
     */

    String  stringDocument=null;


    String docNanme="doc文件名称";



   }
