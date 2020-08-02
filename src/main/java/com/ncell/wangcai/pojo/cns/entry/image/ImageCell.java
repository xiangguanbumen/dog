package com.ncell.wangcai.pojo.cns.entry.image;

import com.ncell.wangcai.pojo.cns.main.base.Cell;

/**
 * 图形细胞
 * 分为两类，
 * 第一类是绝对image细胞，命名为imagecell+rgb值
 * 第二类是关系image细胞，有多个绝对image细胞组合而成，加上表示位置关系的属性值。
 *
 * @author anliwei
 * @date 2020/6/8 18:30
 *
 * @update
 * 2020年8月2日17:08:36
 * 将原来在stem中表示方位，位置关系的信息转到image中
 * 用来表示，两种或多个imageCell形成的复杂的imageCell。
 */
public class ImageCell extends Cell {

    /**
     * @update
     * 2020年7月17日22:48:46
     * 表示方位的属性，只适用于感知细胞，
     * 比如眼睛，表示兴奋细胞所在的位置
     *
     * 比如耳朵的毛细胞至少分左右两大类 。
     *

     *
     * 坐标原点是注意的焦点细胞，
     *
     * 如果没有设置注意细胞，则默认的是图像正中
     *
     * 如果整个视野是偶数，则使用稍小一点的为中点
     */

    int absoluteXLocation;
    int absoluteYLocation;

    /**
     *
     * @update
     * 2020年7月17日23:08:18
     *
     * 仿照位置关系细胞
     * 设置不同的精度
     * 4精度将整个屏幕横向分为4个，整个视野分成16部分
     * 8精度将整个屏幕横向分为8个，整个视野分成64部分
     * 16精度将整个屏幕横向分为16个，整个视野分成256部分
     *
     */

    int roughXLocation4;
    int roughYLocation4;

    int roughXLocation8;
    int roughYLocation8;

    int roughXLocation16;
    int roughYLocation16;




    /**
     *
     * @update
     * 2020年7月17日23:22:54
     * 使用极坐标标记方向
     *
     * 360度
     * 分成12份，每一部分30度
     * 或者分成24份，每一部分15度
     *
     */

    int polarCoordinates12;

    int polarCoordinates24;

    /**
     * @update
     * 2020年7月17日23:25:22
     * 相对距离
     * 采用int来存储
     * 8等级
     * 16个等级，
     */

    int roughSpan8;

    int roughSpan16;

}
