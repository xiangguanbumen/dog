package com.ncell.wangcai.service.mapperService.impl;

import com.ncell.wangcai.mapper.CellMapper;
import com.ncell.wangcai.pojo.cns.main.Cell;
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
    public int deleteCell(String stemName) {
        return cellMapper.deleteCell(stemName);
    }

    @Override
    public int updateCell(String cellName, Cell cell) {
        return cellMapper.updateStem(cellName,cell);
    }

    @Override
    public Stem findCell(String stemName) {
        return cellMapper.findCell(stemName);
    }

    @Override
    public List<Cell> findAllCell() {
        return cellMapper.findAllCell();
    }

    @Override
    public int addCell(Cell cell) {
        return cellMapper.addCell(cell);
    }

    /**
     * 清空数据库cell_table
     */
    @Override
    public void truncateTable() {
        cellMapper.truncateTable();
    }
}
