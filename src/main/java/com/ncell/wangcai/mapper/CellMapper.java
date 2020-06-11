package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/10 20:02
 */

public interface CellMapper {

    /**
     * 删除
     * @param cellName
     * @return
     */
    @Delete("DELETE FROM cell_table WHERE name = #{cellName}")
    int deleteCell(String cellName);

    /**
     * 暂时不需要
     * @param cellName
     * @param cell
     * @return
     */
    @Update("")
    int updateStem(String cellName, Cell cell);

    /**
     * 查找
     * @param cellName
     * @return
     */
    @Select("select * from cell_table where name = #{cellName}")
    Cell findCell(String cellName);

    /**
     * 查找所有cell实体类
     * @return
     */
    @Select("select * from cell_table ")
    List<Cell> findAllCell();


    //todo 暂时使用固定id。

    /**
     * 保存到数据库
     * @param cell
     * @return
     */
    @Insert("insert into cell_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")
    int addCell(Cell cell);
}
