package com.ncell.wangcai.pojo.assistant.indicator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 输入状态指示器
 *
 * 从input文件，input仓库中读取数据
 *
 * 指示器是对原始信息的一个初步加工。
 *
 * 不同的数据表示不同文件夹，仓库的状态
 *
 * 进程管理程序从指示器中读取输入相关的状态后
 * 启动或关闭相应的服务
 *
 * @author anliwei
 * @Date 2020/7/16 15:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("inputIndicator")
public class InputIndicator {

    /**
     * 不同的数据表示不同文件夹，仓库的状态
     *
     *
     */

    /**
     * 文档文件夹
     */
    /**
     * 总的标记，所有文档数量（包含word、excel等）
     */

    int documentFileFolderState = 0;

    int wordFileFolderState = 0;
    int excelFileFolderState = 0;
    int pptFileFolderState = 0;
    int pdfFileFolderState = 0;
    int txtFileFolderState = 0;
    int htmlFileFolderState = 0;
    int binaryFileFolderState = 0;

    /**
     * 图像文件夹
     * 其他图像格式
     * 待使用时补充
     */

    int imageFileFolderState = 0;

    int jpgFileFolderState = 0;
    int bmpFileFolderState = 0;

    /**
     * 声音文件夹
     * 其他声音格式
     * 待使用时补充
     */

    int soundFileFolderState = 0;

    int MP3FileFolderState = 0;
    int wavFileFolderState = 0;


    /**
     * 视频文件夹
     * 其他的视频格式
     * 待使用的时候补充
     */
    int videoFileFolderState = 0;

    int MP4FileFolderState = 0;
    int AVIFileFolderState = 0;

    /**
     * 文档仓库
     */

    int documentWarehouseState = 0;
    int normalizedDocumentWarehouseState = 0;

    /**
     * 图像仓库
     */

    int imageWarehouseState = 0;
    int normalizedImageWarehouseState = 0;

    /**
     * 声音仓库
     */

    int soundWarehouseState = 0;
    int normalizedSoundWarehouseState = 0;

    /**
     * 视频仓库
     */


    int videoWarehouseState = 0;
    int normalizedVideoWarehouseState = 0;


}
