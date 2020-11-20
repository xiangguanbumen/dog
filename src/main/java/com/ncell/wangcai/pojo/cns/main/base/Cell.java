package com.ncell.wangcai.pojo.cns.main.base;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 细胞类
 * @author anliwei
 * @Data 2020/6/7 9:50
 */
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Component()
@Scope("prototype")
public class Cell extends Stem {


}
