package com.ncell.wangcai.service.input.impl;

import com.ncell.wangcai.pojo.input.InputModel;
import com.ncell.wangcai.service.input.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author anliwei
 * @Data 2020/6/6 12:29
 */
@Service("inputServiceImpl")
public class InputServiceImpl implements InputService {

    @Autowired
    InputModel inputModel;

    @Override
    public void obtainData() {

    }

    @Override
    public void normalizeData() {

    }

    @Override
    public void sendData() {

    }

    public InputServiceImpl() {
    }
}
