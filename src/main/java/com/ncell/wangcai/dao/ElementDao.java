package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.part.Element;

/**
 * @author anliwei
 * @create 2020/6/10 14:49
 */
public interface ElementDao {
    /**
     * 增加元素
     *
     * @param element
     * @return
     */
    int addElement(Element element);

    /**
     *
     * 根据元素名称修改元素
     *
     * @param name
     * @param element
     * @return
     */
    int updateElement(String name,Element element);

    /**
     * 根据名称查处元素
     * @param name
     * @return
     */
    Element findElement(String name);

    /**
     * 根据名称删除元素
     * @param name
     * @return
     */
    int deleteElement(String name);


}
