package com.ncell.wangcai.service.cns.inputConverter.impl;


import com.ncell.wangcai.pojo.cns.main.warehouse.CellWarehouse;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import com.ncell.wangcai.service.cns.inputConverter.DocCellConvertService;
import com.ncell.wangcai.utils.cns.inputConverter.TextCellUtil;
import com.ncell.wangcai.utils.input.doc.StringUtil;
import lombok.Data;
import org.springframework.stereotype.Service;


/**
 * @author anliwei
 * @Data 2020/6/7 16:59
 */
@Service("docCellConvertServiceImpl")


@Data
public class DocCellConvertServiceImpl implements DocCellConvertService {

    String userinput;

    TextCellUtil textCellUtil;

    StringUtil stringUtil;


    NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel;

    CellWarehouse cellWarehouse;

    //我什么要单独编写一个构造函数，是因为，多了一个userinput
    public DocCellConvertServiceImpl(TextCellUtil textCellUtil,
                                     StringUtil stringUtil,
                                     NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel,
                                     CellWarehouse cellWarehouse) {
        this.textCellUtil = textCellUtil;
        this.stringUtil = stringUtil;
        this.normalizedDocumentWarehouseModel = normalizedDocumentWarehouseModel;
        this.cellWarehouse = cellWarehouse;
    }

    @Override
    /**
     * 已经通过autowire自动注入，直接使用就可以了
     */
    public void obtainData() {


    }

    @Override
    public void convertDocToCell() throws InterruptedException {

        userinput = normalizedDocumentWarehouseModel
                .getNormalizedDocumentModeLinkedBlockingQueue()
                .take().getNormalizedDocument();

        //依次读取用户输入的每一个字符
        while (!userinput.isEmpty()) {
            Character firstCharacter = stringUtil.obtainFirstCharacter(userinput);
            String cellName = "textCell" + firstCharacter;
            if (textCellUtil.textCellExist(cellName, cellWarehouse)) {
                //如果存在激活，并注册到相应集合中
                textCellUtil.exciteAndRegisterTextCell(cellName, cellWarehouse);
            } else {
                //如果不存在，创造新的textcell并注册到allcell，
                textCellUtil.registerTextCell(textCellUtil.creatTextCell(firstCharacter), cellWarehouse);
            }
            //去掉第一个字符继续遍历
            userinput = userinput.substring(1);

        }

    }

    @Override
    /**
     * 已经在创造或激活的时候传递到细胞仓库这里就不在发送了
     */
    public void sendCell() {


        System.out.println("it works");
    }

    @Override
    public void doService() throws InterruptedException {
        this.obtainData();
        this.convertDocToCell();
        this.sendCell();

    }


}
