package com.ncell.wangcai.service.mapperService;

import com.ncell.wangcai.pojo.cns.main.base.Cell;
import com.ncell.wangcai.pojo.cns.main.stem.Stem;

import java.util.List;

/**
 * @author anliwei
 * @create 2020/6/10 16:22
 */

public interface CellMapperService {
    /**
     * 删除
     * @param cellName
     * @return
     */
    int deleteCell(String cellName);

    /**
     * 更新
     * @param cellName
     * @param cell
     * @return
     */
    int updateCell(String cellName, Cell cell);

    /**
     * 根据名称查找
     * @param cellName
     * @return
     */
    Stem findCell(String cellName);

    /**
     * 查找所有细胞
     * @return
     */
    List<Cell> findAllCell();

    int addCell(Cell cell);

    /**
     * 清空数据库cell_table
     */
    void truncateTable();
}
