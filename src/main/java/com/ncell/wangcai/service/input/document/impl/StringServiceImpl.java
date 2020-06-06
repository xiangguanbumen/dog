package com.ncell.wangcai.service.input.document.impl;

import com.ncell.wangcai.service.input.document.StringService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anliwei
 * @Data 2020/6/6 13:17
 */
@Service("StringServiceImpl")
public class StringServiceImpl implements StringService {

    String userInput;

    @Override
    public void obtainData() {

    }

    public void obtainData(HttpServletRequest req) {
        userInput=req.getParameter("inputtext");

    }

    @Override
    public void normalizeData() {

        userInput=userInput.concat(",正在解析中");

    }

    @Override
    public void sendData() {
        System.out.println(userInput);
    }

    @Override
    public void doService() {

    }
}
