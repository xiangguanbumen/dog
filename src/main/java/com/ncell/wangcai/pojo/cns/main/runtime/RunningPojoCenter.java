package com.ncell.wangcai.pojo.cns.main.runtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 不是所有的兴奋细胞都有，只保存要生成新的连接的细胞
 * @update
 * 2020年6月24日11:16:32
 * 经过各种服务处理的兴奋pojo组合在一起形成一个个的pojo组。
 *
 * 因为可能有重复的元素，所有使用list存储，
 * 使用非并发的list一是这里没有并发操作，二是为了提高读写效率。
 * @author anliwei
 * @Date 2020/6/11 20:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("runningPojoCenter")
public class RunningPojoCenter {
    /**
     * 第一个string保存产生消息的pojo的名称，第二个String没有意义可以重复，因为没有并发set，使用hashMap取代
     */
    //ConcurrentHashMap<String, String> pojoInRunningPojoCenter = new ConcurrentHashMap(1024000);
    
    /**
     * 时间分组
     * linkedList保存pojo名称
     */
    ConcurrentHashMap<String, LinkedList> pojoGroupByTime = new ConcurrentHashMap(1024000);
    /**
     * 空间分组
     */
    ConcurrentHashMap<String, LinkedList> pojoGroupBySpace = new ConcurrentHashMap(1024000);
    /**
     * 颜色分组
     */
    ConcurrentHashMap<String, LinkedList> pojoGroupByColorGray = new ConcurrentHashMap(1024000);
    ConcurrentHashMap<String, LinkedList> pojoGroupByColorGreen = new ConcurrentHashMap(1024000);
    ConcurrentHashMap<String, LinkedList> pojoGroupByColorBlue = new ConcurrentHashMap(1024000);
    ConcurrentHashMap<String, LinkedList> pojoGroupByColorRed = new ConcurrentHashMap(1024000);

    /**
     * 声音分组
     * linkedList保存pojo名称
     */
    ConcurrentHashMap<String, LinkedList> pojoGroupBySoundVolume = new ConcurrentHashMap(1024000);
    ConcurrentHashMap<String, LinkedList> pojoGroupBySoundFrequency = new ConcurrentHashMap(1024000);

    /**
     * 连接分组
     */
    ConcurrentHashMap<String, LinkedList> pojoGroupByConnectionFrequency = new ConcurrentHashMap(1024000);
    ConcurrentHashMap<String, LinkedList> pojoGroupByConnectionStrength = new ConcurrentHashMap(1024000);

    /**
     * 还有其他的分类，根据需要再增加
     */

}
