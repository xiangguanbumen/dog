package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.part.ElementCss;

/**
 * @author anliwei
 * @create 2020/6/9 12:36
 */
public interface ElementCssMapper {
    /**
     * 增加elementCss
     * @param elementCss
     * @return
     */
    int addElementCss(ElementCss elementCss);

    /**
     * 更新elementCss
     * @param elementCssName elementCss
     * @return
     */
    int updateElementCss(String elementCssName,ElementCss elementCss);

    /**
     *
     * 根据名称查找ElementCss
     * @param elementCssName
     * @return
     */
    ElementCss findElementCss(String elementCssName);

    /**
     * 删除elementCss
     * @param elementCssName
     * @return
     */
    int deleteElementCss(String elementCssName);

}