package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.stem.Stem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

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
    @Insert("insert into stem_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")
    int addStem(Stem stem);

    /**
     * 删除元素（包括cell，agent，tissue等）
     * @param stemName
     * @return
     */
    @Delete("delete from stem_table where name = #{stemName}")
    int deleteStem(String stemName);

    /**
     * 修改元素（包括cell，agent，tissue等）
     * @param stemName,stem
     * @return int
     */
    @Update("update stem_table set type=#{type} ,currentState=#{currentState} where name = #{name}")
    int updateStem(@Param("stemName") String stemName, @Param("stem")Stem stem);

    /**
     * 查找元素（包括cell，agent，tissue等）
     * @param stemName
     * @return Stem
     */
    Stem findStem(String stemName);


}
