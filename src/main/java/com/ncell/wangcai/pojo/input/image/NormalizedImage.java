package com.ncell.wangcai.pojo.input.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import java.awt.*;

/**
 * @author anliwei
 * @Data 2020/6/7 9:09
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component("normalizedImageMoel")
public class NormalizedImage {
    /**
     * 使用位图（点阵图）来保存标准化后的图形
     * 每一帧原始图形，根据rgb分成三个图层，即每一帧原始图形，分解成三张图形
     */

    Image Rimage;
    Image Gimage;
    Image Bimage;

}
