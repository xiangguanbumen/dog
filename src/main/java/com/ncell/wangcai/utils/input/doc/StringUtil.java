package com.ncell.wangcai.utils.input.doc;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author anliwei
 * @Data 2020/6/7 19:01
 */
@Component("stringUtil")
@NoArgsConstructor
public class StringUtil {
    /**
     * 获取首个字符
     * @param str
     * @return
     */
    public Character obtainFirstCharacter(String str){
        if (!str.isEmpty())
        {Character firstCharacter =str.charAt(0);
            return firstCharacter;}
        else {
            return null;
        }
    }
}
