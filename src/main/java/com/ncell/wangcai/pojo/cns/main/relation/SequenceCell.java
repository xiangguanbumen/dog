package com.ncell.wangcai.pojo.cns.main.relation;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 时间相关细胞
 * 序列细胞，
 * 只关心事件的先后顺序
 * 当有单个pojo兴奋时，静息时；
 * （单个细胞暂时不考虑）
 * 或是两个pojo先后兴奋，先后静息。
 * 一个静息一个兴奋，
 * 一个兴奋一个静息
 * 等四种情况时
 * 分为几类不同的时间细胞
 *
 * 继承自stem。
 * 不同的event细胞的变化主要是
 * elementJS的变化
 * @author anliwei
 * @date 2020/7/13 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class SequenceCell extends Stem {

}
