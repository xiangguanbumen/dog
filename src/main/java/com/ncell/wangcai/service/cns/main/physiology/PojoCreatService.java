package com.ncell.wangcai.service.cns.main.physiology;

/**
 * 主要是通过分析runningMessageCenter的message来建立新的pojo
 *
 * @author anliwei
 * @Date 2020/6/11 20:26
 */
public interface PojoCreatService {
    /**
     * 直接将生成的pojo放到对应的仓库中
     */
    void creat();
}
