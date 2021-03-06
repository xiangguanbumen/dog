package com.ncell.wangcai.pojo.cns.entry.sound;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * 声音细胞，
 * 分为两类
 * 一类是绝对声音细胞，
 * 按照每一个采样值对应一个声音细胞的比例。
 * 采用soundCell+采样值大小命名，
 * 使用8位和16位两种命名方法
 * 对应的细胞名称分别为
 * soundCell8b+八位采样值大小
 * soundCell16b+十六位采样值大小
 *
 * 另一类是相对声音细胞，
 * 用来表示两个或多个绝对声音细胞之间的关系
 *
 *
 * @author anliwei
 * @date 2020/6/8 18:27
 *
 *
 * @update
 * 2020年8月2日15:54:22
 * 如果按照每一个采样对应一个声音细胞的比例。
 * 人能分辨的最小声音间隔为0.1秒
 * cd频率为44100
 *
 * 5kHz的采样率仅能达到人们讲话的声音质量。
 * 11kHz的采样率是播放小段声音的最低标准，是CD音质的四分之一。
 * 22kHz采样率的声音可以达到CD音质的一半，大多数网站都选用这样的采样率。
 * 44kHz的采样率是标准的CD音质，可以达到很好的听觉效果。
 *
 * 相当于人类大脑的语言中枢的听觉语言中枢
 *
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component()
@Scope("prototype")
public class SoundCell extends Cell {

    /**
     * 两个绝对声音细胞之间的关系
     *
     * 变大
     * 变小
     * 不变
     * 其中变大、变小可以采用不同的分类方法分成几个级别
     *
     * 第一种分类方法
     * 只分三类，
     * 变大
     * 变小
     * 不变
     *
     * 第二种分类方法
     * 分16种
     *
     * 变化的幅度，采用比例绝对值，
     * 变化差值
     * -256、-128、-64、-32、-16、-8、-4、-2、-1、0、1、2、4、8、16、32、64、128、256
     *
     *
     *
     */


    int changeIn3Level;

    int changeIn16Level;

    /**
     * 三个绝对声音细胞之间的关系
     *
     *
     * 第一种简单分类法
     * 共九种组合
     * 平升
     * 平降
     * 平平
     *
     * 升降
     * 升平
     * 升升
     *
     * 降降
     * 降平
     * 降升
     *
     *
     */
}
