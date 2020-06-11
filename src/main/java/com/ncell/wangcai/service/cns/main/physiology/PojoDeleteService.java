package com.ncell.wangcai.service.cns.main.physiology;

/**
 * 当细胞或结构没有输入或输出连接，没有隶属关系时删除
 * @author anliwei
 * @Data 2020/6/11 20:27
 */
public interface PojoDeleteService {
    /**
     * 删除孤立pojo
     * 这个方法还是有一点问题，pojo如果有内部元素的话，要不要删除。
     */
    void delete();
}
