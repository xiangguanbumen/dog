package com.ncell.wangcai.pojo.cns.entry.document;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 文字细胞
 *
 * @author anliwei
 * @Date 2020/6/7 9:40
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class TextCell extends Cell {


}
