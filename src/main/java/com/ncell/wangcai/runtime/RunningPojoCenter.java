package com.ncell.wangcai.runtime;

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
 * 因为可能有重复的元素，所以使用list存储，
 * 使用非并发的list一是这里没有并发操作，二是为了提高读写效率。
 * @author anliwei
 * @Date 2020/6/11 20:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("runningPojoCenter")
public class RunningPojoCenter {


}
