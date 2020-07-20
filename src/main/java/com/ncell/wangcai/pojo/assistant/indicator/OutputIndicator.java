package com.ncell.wangcai.pojo.assistant.indicator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 输出指示器
 *
 * @author anliwei
 * @Date 2020/7/19 16:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("outputIndicator")
public class OutputIndicator {
    int output=0;
}
