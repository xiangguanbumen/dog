package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.stem.Stem;

/**
 * @author anliwei
 * @create 2020/6/9 11:18
 */
public interface StemDao {
    /**
     * 增加元素（包括cell，agent，tissue等）
     * @param  stem
     * @return
     */
    int addStem(Stem stem);

    /**
     * 删除元素（包括cell，agent，tissue等）
     * @param stemName
     * @return
     */
    int deleteStem(String stemName);

    /**
     * 修改元素（包括cell，agent，tissue等）
     * @param stemName,stem
     * @return int
     */
    int updateStem(String stemName,Stem stem);

    /**
     * 查找元素（包括cell，agent，tissue等）
     * @param stemName
     * @return Stem
     */
    Stem findStem(String stemName);


}
