package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.base.Scene;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 场景仓库
 * @author anliwei
 * @Data 2020/6/7 12:15
 */
@Component("sceneWarehouse")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SceneWarehouse {
    String name = "sceneWarehouse";
    ConcurrentHashMap<String, Scene> allScene = new ConcurrentHashMap<String, Scene>(1024000);
}
