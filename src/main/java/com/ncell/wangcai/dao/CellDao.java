package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.stem.Stem;
import org.apache.ibatis.annotations.Insert;

/**
 * @author anliwei
 * @create 2020/6/10 16:22
 */
public interface CellDao extends StemDao{

    @Override
    int deleteStem(String stemName);

    @Override
    int updateStem(String stemName, Stem stem);

    @Override
    Stem findStem(String stemName);

    @Override
    @Insert("insert into cell_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")

    int addStem(Stem stem);
}
