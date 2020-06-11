package com.ncell.wangcai.service.mapperService.impl;

import com.ncell.wangcai.mapper.CellMapper;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;
import com.ncell.wangcai.service.mapperService.CellMapperService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author anliwei
 * @Data 2020/6/10 20:06
 */
@Service("cellMapperServiceImpl")
@AllArgsConstructor
@Data
public class CellMapperServiceImpl implements CellMapperService {

    private CellMapper cellMapper;

    @Override
    public int deleteStem(String stemName) {
        return cellMapper.deleteCell(stemName);
    }

    @Override
    public int updateStem(String stemName, Stem stem) {
        return cellMapper.updateStem(stemName,stem);
    }

    @Override
    public Stem findStem(String stemName) {
        return cellMapper.findCell(stemName);
    }

    @Override
    public List<Stem> findAllStem() {
        return cellMapper.findAllCell();
    }

    @Override
    public int addStem(Stem stem) {
        return cellMapper.addCell(stem);
    }
}
