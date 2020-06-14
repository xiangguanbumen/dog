package com.ncell.wangcai.pojo.reptilian.food;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 食物中枢，判断是否是可以食用。根据连接值确定，当pojo与食物中枢直接连接且连接强度大就是食物。
 *
 * 单例类
 *
 * @author anliwei
 * @Date 2020/6/14 19:34
 */
@Component("foodCentre")
@Scope("singleton")
public class FoodCentre extends Stem {
}
