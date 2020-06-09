package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.part.ElementCss;
import com.ncell.wangcai.pojo.cns.common.part.ElementJs;

/**
 * @author anliwei
 * @create 2020/6/9 11:17
 */
public interface ElementJsDao {

    /**
     * 增加elementJs
     * @param elementJs
     * @return
     */
    int addElementJs(ElementJs elementJs);

    /**
     * 更新elementJs
     * @param elementJsName elementJs
     * @return
     */
    int updateElementJs(String elementJsName,ElementCss elementJs);

    /**
     *
     * 根据名称查找ElementJs
     * @param elementJsName
     * @return
     */
    ElementCss findElementJs(String elementJsName);

    /**
     * 删除elementJs
     * @param elementJsName
     * @return
     */
    int deleteElementJs(String elementJsName);
}
