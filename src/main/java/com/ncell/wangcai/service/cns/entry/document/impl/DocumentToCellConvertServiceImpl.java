package com.ncell.wangcai.service.cns.entry.document.impl;


import com.ncell.wangcai.warehouse.product.CellWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.cns.entry.document.DocumentToCellConvertService;
import com.ncell.wangcai.utils.cns.inputConverter.TextCellUtil;
import com.ncell.wangcai.utils.input.document.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.LinkedList;


/**
 * 将用户输入的信息转换为细胞
 *
 * @author anliwei

 * @Date 2020/6/7 16:59
 *
 * @update 2020年7月11日11:04:17
 * 将所有的标准化后的文档数据转换为细胞
 *
 * @update
 * 2020年8月4日17:25:49
 * 输入不仅有实质的转换还有关系的转换，
 * 此时只是形式上的关系，
 * 需要关系细胞加入
 *
 */
@Service("documentToCellConvertServiceImpl")
@AllArgsConstructor
@Data
public class DocumentToCellConvertServiceImpl implements DocumentToCellConvertService {

    TextCellUtil textCellUtil;
    StringUtil stringUtil;
    NormalizedDocumentWarehouse normalizedDocumentWarehouse;
    CellWarehouse cellWarehouse;

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.convertDocToCell();
        this.sendCell();
        // System.out.println("将文字输入转换成textCell，并发送到cellWarehouse");

    }

    @Override
    /**
     * 已经通过变量自动注入，直接使用就可以了
     */
    public void obtainData() {
    }

    @Override
    public void convertDocToCell() throws InterruptedException {

        while (!normalizedDocumentWarehouse
                .getNormalizedDocumentLinkedBlockingQueue().isEmpty()) {
            String normalizeString = normalizedDocumentWarehouse
                    .getNormalizedDocumentLinkedBlockingQueue()
                    .take().getNormalizedDocument();


            LinkedList cellNameList = new LinkedList();

            //依次读取每一个字符
            while ((normalizeString != null) && (!normalizeString.isEmpty())) {
                Character firstCharacter = stringUtil.obtainFirstCharacter(normalizeString);
                String cellName = "textCell" + firstCharacter;
                /**
                 *  转换成为textCell，并存储到相应的动态，静态仓库中.
                 *  存储的操作本来属于send方法的范围，但是如果分开来处理的话，
                 *  需要增加新的结构，虽然利于后期维护，但是降低了效率，
                 *  此处先一起处理，等以后再优化代码
                 */
                //todo 不符合分层的原则。发送要用send方法单独处理
                textCellUtil.doService(cellName);

                cellNameList.add(cellName);
                //去掉第一个字符
                normalizeString = normalizeString.substring(1);

            }

            //将同时兴奋的一组细胞队列，注册到cell仓库中相应的存储中

            //注册到同时兴奋细胞组hashmap中
            cellWarehouse.getGroupExcitedCell().put(System.currentTimeMillis(),cellNameList);
            //注册到输入文档细胞队列
            cellWarehouse.getInputTextCellListQueue().add(cellNameList);

        }
    }

    @Override
    /**
     * 已经在创造或激活的时候传递到细胞仓库这里就不在发送了
     */
    public void sendCell() {

        //将同一批转换好的文字细胞打包存放到兴奋细胞队列
       // cellWarehouse.getExcitedCellPackageQueue().add(cellWarehouse.getInputTextCellQueue());

    }


}
