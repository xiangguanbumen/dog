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
            textCellUtil.doService(cellName);
            userInput = userInput.substring(1);

        }

    }

    @Override
    /**
     * 已经在创造或激活的时候传递到细胞仓库这里就不在发送了
     */
    public void sendCell() {

    }

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.convertDocToCell();
        this.sendCell();
        System.out.println("将文字输入转换成textcell");

    }


}
