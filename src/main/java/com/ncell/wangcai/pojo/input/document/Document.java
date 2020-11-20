package com.ncell.wangcai.pojo.input.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 文档类，存储所有接受的文档
 *
 * @author anliwei
 * @create 2020/6/4 9:06
 * @update 2020年7月10日16:52:59
 *
 *
 * @update
 * 2020年8月9日16:01:25
 *
 * 可以使用poi处理的微软格式文档，不在转换成document。
 * 直接存储到document仓库中
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("document")
@Scope("prototype")
public class Document {

    //需要引入poi相关资料，进行Word，Excel等格式的解析,

    /**
     * 接受整个word文档
     * @update
     * 2020年8月9日12:46:05
     *
     */

    Object wordDocument=null;

    /**
     * 接收Word格式文档文件，
     * @update
     * 2020年7月10日16:53:14
     * 接受内容调整为文档的每一个段落，
     * poi是以段落来切分word
     */
    Object wordParagraph=null;


    /**
     *
     * 接受整个excel文档
     *
     * @update
     * 2020年8月9日12:47:32
     *
     */

    Object excelDocument=null;

    /**
     * 接收Excel格式文档文件
     * @update
     * 2020年7月10日16:54:16
     * 接受内容调整为excel的每一个cell
     * poi以cell来处理数据
     *
     * @update
     * 2020年7月11日13:18:18
     * 为方便，使用string接收数据
     */
    String excelCell=null;
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


    String docName ="doc文件名称";



   }
