package com.ncell.wangcai.pojo.cns.main.warehouse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/15 14:35
 */
@Component("warehouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {


    AgentWarehouse agentWarehouse;
    CellWarehouse cellWarehouse;
    ConnectionWarehouse connectionWarehouse;
    ElementCssWarehouse elementCssWarehouse;
    ElementJsWarehouse elementJsWarehouse;
    ElementWarehouse elementWarehouse;
    MessageWarehouse messageWarehouse;
    SceneWarehouse sceneWarehouse;
    StoryWarehouse storyWarehouse;
    TissueWarehouse tissueWarehouse;

}
