package com.ncell.wangcai.pojo.cns.common.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * cell,agent等结构中用来存储自身的信息的类。
 * 不仅可以用来存储到细胞的信息，也可以存储到tissue，到agent等的信息。
 * 其中使用string也就是message的名称来存储信息。
 * 当需要使用的时候到仓库取调取。
 * @author anliwei
 * @Data 2020/6/7 10:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class MessageInModel {


    LinkedList<String> messageOut = null;
    LinkedList<String> messageIn = null;
}
