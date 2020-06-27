package com.ncell.wangcai.service.cns.inputConverter.impl;


import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouse;
import com.ncell.wangcai.service.cns.inputConverter.DocumentToCellConvertService;
import com.ncell.wangcai.utils.cns.inputConverter.TextCellUtil;
import com.ncell.wangcai.utils.input.doc.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


/**
 * @author anliwei
 * @Data 2020/6/7 16:59
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
    /**
     * 已经通过autowire自动注入，直接使用就可以了
     */
    public void obtainData() {
    }

    @Override
    public void convertDocToCell() throws InterruptedException {

        String  userInput = normalizedDocumentWarehouse
                .getNormalizedDocumentLinkedBlockingQueue()
                .take().getNormalizedDocument();

        //依次读取用户输入的每一个字符

        while (!userInput.isEmpty()) {
            Character firstCharacter = stringUtil.obtainFirstCharacter(userInput);
            String cellName = "textCell" + firstCharacter;
            /**
             *  转换成为textCell，并存储到相应的动态，静态仓库中.
             *  存储的操作本来属于send方法的范围，但是如果分开来处理的话，
             *  需要增加新的结构，虽然利于后期维护，但是降低了效率，
             *  此处先一起处理，等以后再优化代码
             */
           //todo 不符合分层的原则。发送要用send方法单独处理
            textCellUtil.doService(cellName);

            userInput = userInput.substring(1);

        }

    }

    @Override
    /**
     * 已经在创造或激活的时候传递到细胞仓库这里就不在发送了
     */
    public void sendCell() {

        //将同一批转换好的文字细胞打包存放到兴奋细胞队列
        cellWarehouse.getExcitedCellPackageQueue().add(cellWarehouse.getInputTextCellQueue());

    }

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.convertDocToCell();
        this.sendCell();
        System.out.println("将文字输入转换成textCell，并发送到cellWarehouse");

    }


}
