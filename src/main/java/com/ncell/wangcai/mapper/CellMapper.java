package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.common.stem.Stem;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/10 20:02
 */

public interface CellMapper {

    @Delete("")
    int deleteStem(String stemName);

    @Update("")
    int updateStem(String stemName, Stem stem);


    @Select("select * from cell_table where name = #{stemName}")
    Stem findStem(String stemName);

    /**
     * 查找所有stem实体类
     * @return
     */
    @Select("select * from cell_table ")
    List<Stem> findAllStem();


    //todo 暂时使用固定id。
   // @Options(keyProperty = "Cell.id", useGeneratedKeys = true)
    @Insert("insert into cell_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")
    int addStem(Stem stem);
}
