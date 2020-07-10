package com.ncell.wangcai.utils.learn;


import com.ncell.wangcai.pojo.input.document.Document;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouse;
import com.ncell.wangcai.service.input.document.impl.DocumentServiceImpl;
import com.ncell.wangcai.service.input.document.impl.StringServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anliwei
 * @Date 2020/7/9 19:33
 */
@AllArgsConstructor
@Data
@Service("excelUnit")
public class ExcelUnit {

    StringServiceImpl stringService;
    Document document;
    DocumentWarehouse documentWarehouse;
    /**
     * 2003- 版本的excel
     * 2007+ 版本的excel
     */

    private final static String excel2003L =".xls";
    private final static String excel2007U =".xlsx";

    public  void readExcelCell(File file) throws Exception{
        List<List<Object>> list = null;

        //创建Excel工作薄
        Workbook work = this.getWorkbook(file);
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        //遍历Excel中所有的sheet
        for (int i = 0; i <work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){continue;}

            //遍历当前sheet中的所有行
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if(row==null||row.getFirstCellNum()==j){continue;}
                //这里只遍历需要的列。没有遍历所有列
                cell = row.getCell(1);
                document.setExcelCell(cell);
                documentWarehouse.getDocumentLinkedBlockingQueue().put(document);
                System.out.println("将cell内容添加到doc仓库");

            }
        }
    }

    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param file
     * @return
     * @throws Exception
     */
    public  Workbook getWorkbook(File file) throws Exception{
        Workbook wb = null;
        String fileType = file.getName().substring(file.getName().lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            //2003-
            wb = new HSSFWorkbook(new FileInputStream(file));
        }else if(excel2007U.equals(fileType)){
            //2007+
            wb = new XSSFWorkbook(new FileInputStream(file));
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }

    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    public  String getCellValue(Cell cell){
        //用String接收所有返回的值
        String value = null;
        //格式化number String字符
        DecimalFormat df = new DecimalFormat("0");
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        //格式化数字
        DecimalFormat df2 = new DecimalFormat("0.00");

        switch (cell.getCellType()) {

            //String类型的数据
            case STRING:
                value =  cell.getStringCellValue();

                break;

            //数值类型(取值用cell.getNumericCellValue() 或cell.getDateCellValue())
            case NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());


                }else if(HSSFDateUtil.isCellDateFormatted(cell)){
                    value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));


                }else{
                    value = df2.format(cell.getNumericCellValue());


                }
                break;

            //Boolean类型
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;


            //表达式类型
            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;

            //异常类型 不知道何时算异常
            case ERROR:
                value=String.valueOf(cell.getErrorCellValue());
                break;

            //空，不知道何时算空
            case BLANK:
                value = "";
                break;
            //无，不知道何时算空
            case _NONE:
                value = "";
                break;


            default:
                value = "";
                break;
        }
        if(value.equals("")||value==null){
            value = "";
        }
        if (cell == null) {
            return "";
        }
        return value;
    }

}


