package com.ncell.wangcai.service.cns.main.physiology.pojo;

/**
 * 1、通过分析runningMessageCenter的message来建立新的pojo
 * 2、通过处理已经兴奋的pojo产生新的pojo
 * 3、直接命令，也是通过调用方法一，二实现。
 *
 *
 * @author anliwei
 * @Date 2020/6/11 20:26
 */
public interface PojoCreatService {
    /**
     * 总的方法
     */
    void doCreat();

    /**
     * 通过消息生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    void creatPojoByMessage();

    /**
     * 通过已经兴奋的pojo生产pojo
     * 将生成的pojo放到对应的仓库中
     */
    void creatPojoByPojo();

}
