package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.base.Tissue;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/11 17:18
 */
public interface TissueMapper {
    /**
     * 删除
     * @param tissueName
     * @return
     */
    @Delete("DELETE FROM tissue_table WHERE name = #{tissueName}")
    int deleteCell(String tissueName);

    /**
     *更新
     * @param tissueName
     * @param tissue
     * @return
     */
    @Update("")
    int updateStem(String tissueName, Tissue tissue);

    /**
     * 通过实体类名称查找
     * @param tissueName
     * @return
     */
    @Select("select * from tissue_table where name = #{tissueName}")
    Stem findTissueByName(String tissueName);

    /**
     * 查找所有tissue实体类
     * @return
     */
    @Select("select * from tissue_table ")
    List<Stem> findAllTissue();


    //todo 暂时使用固定id。

    /**
     * 保存到数据库
     * @param tissue
     * @return
     */
    @Insert("insert into tissue_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")
    int addTissue(Tissue tissue);
}
