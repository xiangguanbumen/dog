package com.ncell.wangcai.pojo.cns.common.part;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * 具体的连接实体类，可以连接细胞与细胞，也可以连接细胞与tissue，也可以连接tissue与agent，一切的实体类都可以连接
 *
 * @author anliwei
 * @Data 2020/6/7 10:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
public class Connection {

    String connectionName;
    String connectionFrom;
    String connectionTo;
    int connectionType;
    int excitedCount;
    long creatTime;
    long lastExcitedTime;

}
