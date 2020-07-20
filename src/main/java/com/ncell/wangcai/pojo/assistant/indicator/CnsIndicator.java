package com.ncell.wangcai.pojo.assistant.indicator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * cns状态指示器
 * <p>
 * 从cell仓库中读取数据
 * <p>
 * 指示器是对原始信息的一个初步加工。
 * <p>
 * 不同的数据表示不同的状态
 * <p>
 * 进程管理程序从指示器中读取输入相关的状态后
 * 启动或关闭相应的服务
 *
 * @author anliwei
 * @Date 2020/7/16 15:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("cnsIndicator")
public class CnsIndicator {

    /**
     * 所有细胞
     */
    int allCellState = 0;
    int directionCellState = 0;
    int spanCellState = 0;
    int sequenceCellState = 0;
    int intervalCellState = 0;
    int textCellState = 0;
    int imageCellState = 0;
    int soundCellState = 0;


    /**
     * 转换后细胞状态
     */
    int inputTextCellListQueueState = 0;
    int inputSoundCellListQueueState = 0;
    int inputImageCellListQueueState = 0;
    int inputVideoCellListQueueState = 0;

    /**
     * 运行时细胞状态
     */
    int excitedCellState = 0;
    int groupExcitedCellState = 0;
    int excitedCellQueueState = 0;
    int excitedCellQueueForSendMessageState = 0;
    int excitedCellQueueForGenerateNewCellState = 0;
    int excitedCellQueueForStateServiceState = 0;
    int partExcitedCellState = 0;

    /**
     * 兴奋细胞分组以后存储状态
     */

    int pojoGroupByTimeState = 0;
    int pojoGroupBySpaceState = 0;
    int pojoGroupByColorGrayState = 0;
    int pojoGroupByColorGreenState = 0;
    int pojoGroupByColorBlueState = 0;
    int pojoGroupByColorRedState = 0;
    int pojoGroupBySoundVolumeState = 0;
    int pojoGroupBySoundFrequencyState = 0;
    int pojoGroupByConnectionFrequencyState = 0;
    int pojoGroupByConnectionStrengthState = 0;




}
