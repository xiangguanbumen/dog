package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.stem.Stem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author anliwei
 * @create 2020/6/10 16:22
 */

public interface CellDao {


    int deleteStem(String stemName);


    int updateStem(String stemName, Stem stem);



    Stem findStem(String stemName);


    int addStem(Stem stem);
}
