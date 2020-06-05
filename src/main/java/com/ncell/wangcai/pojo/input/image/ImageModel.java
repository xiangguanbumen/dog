package com.ncell.wangcai.pojo.input.image;

import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 9:16
 */
@Component("imageModel")
public class ImageModel {
    String imageName="image文档名称";

    public ImageModel() {

    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
