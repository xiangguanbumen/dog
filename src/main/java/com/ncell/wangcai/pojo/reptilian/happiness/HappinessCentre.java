package com.ncell.wangcai.pojo.reptilian.happiness;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 幸福中枢，复杂对事件，场景评价
 * 单例类
 * @author anliwei
 * @Date 2020/6/14 19:43
 */
@Component("happinessCentre")
@Scope("singleton")
public class HappinessCentre extends Stem {
}
