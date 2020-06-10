package com.ncell.wangcai.service.mapperService.impl;

import com.ncell.wangcai.mapper.CellMapper;
import com.ncell.wangcai.pojo.cns.common.stem.Stem;
import com.ncell.wangcai.service.mapperService.CellService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/10 20:06
 */
@Service("cellServiceImpl")
public class CellServiceImpl implements CellService {

    @Autowired
    private CellMapper cellMapper;

    @Override
    public int deleteStem(String stemName) {
        return cellMapper.deleteStem(stemName);
    }

    @Override
    public int updateStem(String stemName, Stem stem) {
        return cellMapper.updateStem(stemName,stem);
    }

    @Override
    public Stem findStem(String stemName) {
        return cellMapper.findStem(stemName);
    }

    @Override
    public List<Stem> findAllStem() {
        return cellMapper.findAllStem();
    }

    @Override
    public int addStem(Stem stem) {
        return cellMapper.addStem(stem);
    }
}
