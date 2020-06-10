package com.ncell.wangcai.dao;

import com.ncell.wangcai.pojo.cns.common.part.Connection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author anliwei
 * @create 2020/6/9 11:16
 */
@Mapper
public interface ConnectionDao {
    /**
     * 增加连接
     * @param connection
     * @return
     */
    @Insert(" insert into connection_table (id,name,owner,connectionFrom,connectionTo,connnectionType,excitedCount,createTime,lastExcitedTime) " +
            "values (#{id},#{name},#{owner},#{connectionFrom},#{connectionTo},#{connnectionType},#{excitedCount},#{createTime},#{lastExcitedTime})")
    int addConnection(Connection connection);

    /**
     * 修改连接
     * @param connectionName,connection
     * @return
     */
    int updateConnection(String connectionName,Connection connection);

    /**
     * 查找连接
     * @param connectionName
     * @return
     */
    Connection findConnection(String connectionName);

    /**
     * 删除连接
     * @param connectionName
     * @return
     */
    int deleteConnection(String connectionName);







}
