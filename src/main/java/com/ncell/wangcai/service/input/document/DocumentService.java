package com.ncell.wangcai.service.input.document;


import com.ncell.wangcai.pojo.input.document.NormalizedDocument;

/**
 * @author anliwei
 * @Date 2020/6/6 13:00
 * @upadte 2020-7-10 12:20:23
 */
public interface DocumentService  {
    /**
     * 整体调用其他几个服务，统一对外
     */
    void doService() ;

    /**
     * 本地文档服务
     */
    void doLocalDocumentService();

    /**
     * 网络文档服务
     */
    void doWebDocumentService();

    /**
     * 用户输入文档服务
     */
    void doUserInputDocumentService();

    /**
     * 获取数据
     */
    void obtainData();


    /**
     * 获取本地文档（指定的本地文件夹）
     * 主要是用作系统训练时使用。
     */
    void obtainLocalDocument();

    /**
     * 获取web文档
     * 可以是生产环境用户指定，也可以是系统训练
     */

    void obtainWebDocument();

    /**
     * 获取用户输入文档（也是一个固定的用户上传文档的存储文件夹）
     * 主要是用作生产环境
     */
    void obtainUserInputDocument();

    /**
     * 标准化数据
     */
    void normalizeData();

    /**
     * 标准化本地文档数据
     */
    void normalizeLocalDocument();

    /**
     * 标准化网络文档数据
     */
    void normalizeWebDocument();

    /**
     * 标准化用户输入文档数据
     */
    void normalizeUserInputDocument();

    /**
     * 发送数据
     * 2020年6月7日00:01:32
     * 以后将程序部署为分布式，在使用restfull编码，每一个都对应一个接口，目前只是分层，没有分布。
     * 不需要senddata，高层来低层的仓库取数据就可以了
     */
    void sendData(NormalizedDocument normalizedDocument);

}
