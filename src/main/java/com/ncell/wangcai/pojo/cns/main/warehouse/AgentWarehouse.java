package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.Agent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anliwei
 * @Data 2020/6/7 12:15
 */
@Component("agentWarehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentWarehouse {
    String name = "agentWarehouse";
    ConcurrentHashMap<String, Agent> allAgent =new ConcurrentHashMap<String, Agent>(10240000);
}
