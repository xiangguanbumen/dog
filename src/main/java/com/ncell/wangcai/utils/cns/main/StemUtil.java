package com.ncell.wangcai.utils.cns.main;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.pojo.cns.main.warehouse.Warehouse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @create 2020/6/15 15:09
 */
@Component("stemUtil")
@AllArgsConstructor
@NoArgsConstructor
public class StemUtil {

    Warehouse warehouse;

    String str1 = "cell";
    String str2 = "tissue";
    String str3 = "agent";
    String str4 = "scene";
    String str5 = "story";

    /**
     * 根据输入的字符串索引到仓库中去查找pojo实体类
     * @param stemName
     * @return
     */
    public Stem findStemByName(String stemName) {
        if (stemName.contains(str1)) {
            return warehouse.getCellWarehouse().getAllCell().get(stemName);
        } else if (stemName.contains(str2)) {
            return warehouse.getTissueWarehouse().getAllTissue().get(stemName);
        } else if (stemName.contains(str3)) {
            return warehouse.getAgentWarehouse().getAllAgent().get(stemName);
        } else if (stemName.contains(str4)) {
            return warehouse.getSceneWarehouse().getAllScene().get(stemName);
        } else if (stemName.contains(str5)) {
            return warehouse.getStoryWarehouse().getAllStory().get(stemName);
        }
        //如果都没有返回null
        return null;
    }

    public String findWarehouseNameByStemName(String stemName) {
        if (stemName.contains(str1)) {
            return warehouse.getCellWarehouse().getName();
        } else if (stemName.contains(str2)) {
            return warehouse.getTissueWarehouse().getName();
        } else if (stemName.contains(str3)) {
            return warehouse.getAgentWarehouse().getName();
        } else if (stemName.contains(str4)) {
            return warehouse.getSceneWarehouse().getName();
        } else if (stemName.contains(str5)) {
            return warehouse.getStoryWarehouse().getName();
        }
        //如果都没有返回null
        return null;
    }
}
