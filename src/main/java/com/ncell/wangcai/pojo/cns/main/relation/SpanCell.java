package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 关系细胞
 * 空间距离细胞
 * 主要和关系细胞中direction细胞配合使用
 * 标记两个实体的空间间隔
 * @author anliwei
 * @date 2020/7/13 15:33
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class SpanCell extends Stem {
}
