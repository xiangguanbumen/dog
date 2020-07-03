package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import com.ncell.wangcai.pojo.cns.main.warehouse.ConnectionWarehouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/15 16:33
 */
@Component("connectionUtil")
@AllArgsConstructor
@Data
public class ConnectionUtil {

    ConnectionWarehouse connectionWarehouse;

    /**
     * 当connection被使用后，相应参数调整
     * @param connection
     */
    public void connectionUpdateAfterUsed(Connection connection){
        //设置最后激活时间
        connection.setLastExcitedTime(System.currentTimeMillis());
        //设置激活次数
        if(connection.getExcitedCount()<(Integer.MAX_VALUE-1)) {
            connection.setExcitedCount(connection.getExcitedCount() + 1);
        }
    }

    /**
     * 根据输入输出的细胞名称创建连接
     * @param cellNameFrom
     * @param cellNameTo
     * @return
     */
   public Connection makeConnectionByName(String cellNameFrom,String cellNameTo){
       Connection newConnection = new Connection();
       newConnection.setConnectionFrom(cellNameFrom);
       newConnection.setConnectionTo(cellNameTo);
       newConnection.setCreatTime(System.currentTimeMillis());
       newConnection.setName("from"+cellNameFrom+"to"+cellNameTo);
       newConnection.setOwner(cellNameFrom);
       return newConnection;
   }

    /**
     * 将连接注册到连接仓库
     * @param connection
     */
   public void registerConnection(Connection connection){

       connectionWarehouse.getAllConnection().put(connection.getName(),connection);

   }
}
