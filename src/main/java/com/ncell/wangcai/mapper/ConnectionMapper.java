package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/11 10:24
 */
public interface ConnectionMapper {

    /**
     * 删除
     * @param connectionName
     * @return
     */
    @Delete("DELETE FROM connection_table WHERE name = #{connectionName}")
    int deleteConnection(String connectionName);

    /**
     * 通过连接的拥有者来查找连接
     * @param ownerName
     * @return
     */
    @Select("select * from connection_table WHERE owner=#{ownerName}")
    List<Connection> findConnectionByOwnerName(String ownerName);

    /**
     * 保存到数据库
     * @param connection
     * @return
     */
    @Insert("insert into connection_table (id,name,owner,connectionFrom,connectionTo,connectionType,excitedCount,createTime,lastExcitedTime) values (#{id},#{name},#{owner},#{connectionFrom},#{connectionTo},#{connectionType},#{excitedCount},#{createTime},#{lastExcitedTime})")
    int addConnection(Connection connection);

    /**
     * 查找所有连接
     * @return
     */
    @Select("select * from connection_table ")
    List<Connection> findAllConnection();

    /**
     * 清空数据库connection_table
     */
    @Update("truncate table connection_table")
    void truncateTable();


}
