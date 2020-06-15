package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.part.Connection;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/15 16:33
 */
@Component("connectionUtil")
public class ConnectionUtil {

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
}
