package com.ncell.wangcai.service.mapperService;

import com.ncell.wangcai.pojo.cns.main.stem.Stem;

import java.util.List;

/**
 * @author anliwei
 * @create 2020/6/10 16:22
 */

public interface CellMapperService {

    int deleteStem(String stemName);

    int updateStem(String stemName, Stem stem);

    Stem findStem(String stemName);

    List<Stem> findAllStem();

    int addStem(Stem stem);
}
