package com.ncell.wangcai.serviceset.dogService.manager;

/**
 * @author anliwei
 * @Date 2020/7/16 17:32
 */
public interface ManagerService {

    /**
     * 获取系统状态，将状态值写入
     * indicator
     */
    void obtainSystemStateAndUpdateIndicator();

    /**
     * 读取indicator中系统状态值
     * 根据各种状态值，创建不停的进程，关闭不同的进程
     */
    void startAndSleepOtherService();
}
