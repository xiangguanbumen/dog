package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.Agent;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author anliwei
 * @Date 2020/6/11 18:57
 */
public interface AgentMapper {
    /**
     * 删除
     * @param agentName
     * @return
     */
    @Delete("DELETE FROM agent_table WHERE name = #{agentName}")
    int deleteAgent(String agentName);

    /**
     * 暂时不需要
     * @param agentName
     * @param agent
     * @return
     */
    @Update("")
    int updateAgent(String agentName, Agent agent);

    /**
     * 查找
     * @param agentName
     * @return
     */
    @Select("select * from agent_table where name = #{agentName}")
    Stem findAgent(String agentName);

    /**
     * 查找所有agent实体类
     * @return
     */
    @Select("select * from agent_table ")
    List<Stem> findAllAgent();


    //todo 暂时使用固定id。

    /**
     * 保存到数据库
     * @param agent
     * @return
     */
    @Insert("insert into agent_table (id,name,type,currentState,currentStateStartTime,excitedStateDuration,refractoryPeriod) " +
            "values (#{id},#{name},#{type},#{currentState},#{currentStateStartTime},#{excitedStateDuration},#{refractoryPeriod})")
    int addAgent(Agent agent);

}
