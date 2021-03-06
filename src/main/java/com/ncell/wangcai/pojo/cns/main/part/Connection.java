package com.ncell.wangcai.pojo.cns.main.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * 具体的连接实体类，可以连接细胞与细胞，也可以连接细胞与tissue，也可以连接tissue与agent，一切的实体类都可以连接。
 *
 * connection需要css和js结构吗？
 * 暂时不要了，等下一代升级的时候在添加。
 * @update
 * 2020年7月12日11:03:27
 * 从语料库直接加载的词汇，
 * 这些词汇之间的连接暂时设定为1024
 *
 *
 *
 * @author anliwei
 * @Data 2020/6/7 10:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Connection {

    int id;
    /**
     * connectionName connection+数字序号
     * @update
     * 2020年7月12日11:04:47
     * 连接的名称使用
     * from xxxcell to xxxcell
     */
    String name;
    /**
     * 标记connection的拥有者，告诉系统加载时把这个connection放到哪里去。
     */
    String owner;

    String connectionFrom;
    String connectionTo;
    int connectionType=-1;
    int excitedCount=-1;
    long createTime=-1;
    long lastExcitedTime=-1;

}
