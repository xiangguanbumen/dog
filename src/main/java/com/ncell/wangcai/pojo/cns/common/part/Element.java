package com.ncell.wangcai.pojo.cns.common.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.ref.SoftReference;

/**
 * element表示的是不同pojo实体类的关系。
 * 一个element元素可以隶属于多个不同的pojo。
 *
 * element与connection不同在于一个是表示的物理实体之间的联系，
 * 一个是表示的抽象概念之间的关系。
 *
 * element就是各个pojo实体类，
 * 但是一个实体类可能属于多个更高的实体类。
 * 所以需要单独重新标记。
 *
 * @author anliwei
 * @create 2020/6/9 16:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Element {

    /**
     *
     * element + 数字序列号
     *
     */
    String name;

    /**
     * 使用这个实体类的更高层的实体类
     */

    String owner;

    /**
     * 这个element原来的实体类的具体实例名称
     */
    String value;




}
