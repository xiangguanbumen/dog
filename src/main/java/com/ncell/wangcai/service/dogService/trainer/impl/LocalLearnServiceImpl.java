package com.ncell.wangcai.service.dogService.trainer.impl;

import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import com.ncell.wangcai.service.dogService.trainer.LocalLearnService;
import com.ncell.wangcai.utils.learn.ExcelUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author anliwei
 * @Date 2020/7/9 15:28
 */
@AllArgsConstructor
@Data
@Service("localLearnServiceImpl")
public class LocalLearnServiceImpl implements LocalLearnService {

     Warehouse warehouse;
    ExcelUnit excelUnit;
    //JFileChooser jFileChooser;
    /**
     * 文档学习
     *
     */
    @Override
    public void learnDoc() {


        File dir = new File("c://ncell//doc//excel");
        if(dir.listFiles().length>0){
        for (File file:dir.listFiles()
             ) {
            try {
                excelUnit.readExcelCell(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            file.delete();

        }}

    }

    /**
     * 声音学习
     *
     * @param file
     */
    @Override
    public void learnSound(File file) {

    }

    /**
     * 图像学习
     *
     * @param file
     */
    @Override
    public void learnImage(File file) {

    }

    /**
     * 视频学习
     *
     * @param file
     */
    @Override
    public void learnVideo(File file) {

    }
}
