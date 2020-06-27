package com.ncell.wangcai.pojo.cns.main.warehouse;

import com.ncell.wangcai.pojo.cns.main.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  细胞仓库
 *  分成以下几个部分，
 *  第一部分，allCell所有的细胞都需要注册到这个集合中，是总的仓库
 *  第二部分 excitedCell，兴奋细胞集合，为了快速查找
 *  第三部分，excitedCellQueue和excitedCellPackageQueue分别存储时间相关和时间不太相关的兴奋细胞
 *
 *  2020年6月27日15:24:19
 *  以上各部分还可以根据动静分为
 *  动态仓库，也就是运行的时候随时变换的仓库 workWarehouse
 *  静态仓库，主要是内存存储，类似于数据库。baseWarehouse
 *
 * //细胞仓库,为了减少主ConcurrentHashMap的查询修改压力，不同类型的细胞，建立各自的ConcurrentHashMap。
 * //先查询或修改各个类型细胞的ConcurrentHashMap，然后同步到主ConcurrentHashMap，及其他功能运行的ConcurrentHashMap
 *
 *  @update
 *  2020年6月26日16:39:13
 *  实际的生物体中不可能有多个副本，建立多个副本的思路是不对了。
 *  所有的兴奋细胞任然是保存在allCell这样一个hashMap中，所有的操作最终都是针对这里的实体进行的。
 *  其他的结构中存储的都是一个个的指向实体的string名称。
 *
 * @author anliwei
 * @Data 2020/6/7 11:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("cellWarehouse")
public class CellWarehouse {

    String name = "cellWarehouse";
    /**
     * 所有细胞，实体和string索引
     */
    ConcurrentHashMap<String,Cell> allCell = new ConcurrentHashMap(1024000);

    /**
     * 正在兴奋的细胞
     *
     * excitedCell表格包含所有的兴奋细胞用来进行快速查找。
     */

    ConcurrentHashMap<String,Cell> excitedCell = new ConcurrentHashMap(1024000);


    /**
     * 2020年6月26日16:12:28
     * 不分组存放的兴奋细胞
     */
    ConcurrentLinkedQueue<String>  excitedCellQueue = new ConcurrentLinkedQueue<String>();
    /**
     * 2020年6月26日13:02:31
     * 仿照IP传输协议中使用包传输的方法，将输入侧信号打包处理。
     * 同一组输入的信息，不管时间多久打成一个包进行存储。
     * 因为有的是同一个时间输入的比如照片吗，有的是序列输入的比如声音，
     * 所有全部采用有时间维度的序列方式存储
     *
     * 这种方式只能适用于有明确界限的提交，比如一个http请求，接受到一个照片，文档，
     * 但是如果一直处于传输的流输入就不太适合比如声音输入，我们不可能中断外界声音输入。
     * 此时就存入excitedCellQueue中
     *
     * 2020年6月27日10:38:38
     * 编程的难点在于如何确定包的界限，标准化后，信息以流的方式传入，包的起始信息不好传递进下一层。
     * 等以后处理图片信息时增加packagePojoStates服务
     *
     */

    ConcurrentLinkedQueue<ConcurrentLinkedQueue>  excitedCellPackageQueue=new ConcurrentLinkedQueue();
    //todo 增加packagePojoStates服务用来处理像图片之类的一组pojo 的状态
    /**
     * 为生成消息服务
     */
    ConcurrentHashMap<String,Cell> excitedCellForMessage = new ConcurrentHashMap(1024000);
    /**
     * 为生成拐点服务
     */
    ConcurrentHashMap<String,Cell> excitedCellForTurningPoint = new ConcurrentHashMap(1024000);

    /**
     * 接收到信息的细胞，兴奋与否需要等待控制器调用细胞compare方法决定
     *
     */
    ConcurrentLinkedQueue<String> partExcitedCell = new ConcurrentLinkedQueue<String>();
            //ConcurrentHashMap<String,Cell> partExcitedCell = new ConcurrentHashMap(1024000);

    /**
     * 刚刚兴奋完，不应期细胞
     * @update
     * 2020年6月27日09:18:34
     * 暂时不用
     */
    ConcurrentHashMap<String,Cell> refractoryCell = new ConcurrentHashMap(1024000);


    /**
     * 文字细胞
     */
    ConcurrentHashMap<String,Cell> textCell = new ConcurrentHashMap(1024000);

    /**
     * 从文字转换的文字细胞队列
     * 2020年6月27日12:10:32
     * 可以添加打包的信息到excitedCellPackageQueue
     */

    ConcurrentLinkedQueue<String>  inputTextCellQueue =new ConcurrentLinkedQueue();
    //todo 打包发送信息到excitedCellPackageQueue
}
