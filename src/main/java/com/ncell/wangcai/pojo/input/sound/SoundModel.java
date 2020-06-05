package com.ncell.wangcai.pojo.input.sound;

import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/4 9:12
 */
@Component("soundModel")
public class SoundModel {
    String soundName="sound文件名称";

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public SoundModel(String soundName) {
        this.soundName = soundName;
    }

    public SoundModel() {

    }
}
