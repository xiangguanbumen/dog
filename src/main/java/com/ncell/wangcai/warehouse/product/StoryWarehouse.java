package com.ncell.wangcai.warehouse.product;

import com.ncell.wangcai.pojo.cns.main.base.Story;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 事件仓库
 * @author anliwei
 * @Data 2020/6/7 12:16
 */
@Component("storyWarehouse")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryWarehouse {
    String name = "storyWarehouse";
    ConcurrentHashMap<String, Story> allStory = new ConcurrentHashMap<String, Story>(1024000);

}
