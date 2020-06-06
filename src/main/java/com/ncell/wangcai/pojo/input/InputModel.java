package com.ncell.wangcai.pojo.input;


import com.ncell.wangcai.pojo.input.document.DocumentModel;
import com.ncell.wangcai.pojo.input.document.DocumentWarehouseModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentModel;
import com.ncell.wangcai.pojo.input.document.NormalizedDocumentWarehouseModel;
import com.ncell.wangcai.pojo.input.image.ImageModel;
import com.ncell.wangcai.pojo.input.sound.SoundModel;
import com.ncell.wangcai.pojo.input.video.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/3 10:06
 */

@Component("input")
public class InputModel {


    String name = "巴普洛夫的狗的输入系统";


    DocumentModel documentModel;
    DocumentWarehouseModel documentWarehouseModel;
    NormalizedDocumentModel normalizedDocumentModel;
    NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel;

    ImageModel imageModel;
    SoundModel soundModel;
    VideoModel videoModel;




    public InputModel() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentModel getDocumentModel() {
        return documentModel;
    }

    public void setDocumentModel(DocumentModel documentModel) {
        this.documentModel = documentModel;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public SoundModel getSoundModel() {
        return soundModel;
    }

    public void setSoundModel(SoundModel soundModel) {
        this.soundModel = soundModel;
    }

    public VideoModel getVideoModel() {
        return videoModel;
    }

    public void setVideoModel(VideoModel videoModel) {
        this.videoModel = videoModel;
    }

    public DocumentWarehouseModel getDocumentWarehouseModel() {
        return documentWarehouseModel;
    }

    public void setDocumentWarehouseModel(DocumentWarehouseModel documentWarehouseModel) {
        this.documentWarehouseModel = documentWarehouseModel;
    }

    public NormalizedDocumentWarehouseModel getNormalizedDocumentWarehouseModel() {
        return normalizedDocumentWarehouseModel;
    }

    public void setNormalizedDocumentWarehouseModel(NormalizedDocumentWarehouseModel normalizedDocumentWarehouseModel) {
        this.normalizedDocumentWarehouseModel = normalizedDocumentWarehouseModel;
    }

    public NormalizedDocumentModel getNormalizedDocumentModel() {
        return normalizedDocumentModel;
    }

    public void setNormalizedDocumentModel(NormalizedDocumentModel normalizedDocumentModel) {
        this.normalizedDocumentModel = normalizedDocumentModel;
    }
}
