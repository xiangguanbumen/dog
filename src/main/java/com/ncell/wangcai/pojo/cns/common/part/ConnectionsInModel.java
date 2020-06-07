package com.ncell.wangcai.pojo.cns.common.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * cell,agent等结构中用来存储自身的连接的类。
 * 不仅可以用来存储到细胞的连接，也可以存储到tissue，到agent等的连接。
 * 其中使用string也就是connection的名称来存储连接。
 * 当需要使用的时候到仓库取调取。
 * @author anliwei
 * @Data 2020/6/7 10:01
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Scope("prototype")
public class ConnectionsInModel {

    HashSet<String> inputCellConnection = new HashSet<String>();
    HashSet<String> outputCellConnection = new HashSet<String>();
}
