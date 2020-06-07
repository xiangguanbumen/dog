package com.ncell.wangcai.pojo.input.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 9:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("imageModel")
public class ImageModel {
  String imageName = "图片模型名称";
    /**
     * 存储各种类型图片
     * jpg jpeg png
     *
     */

    Object jpg;

    Object png;

}
