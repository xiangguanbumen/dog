package com.ncell.wangcai.mapper;

import com.ncell.wangcai.pojo.cns.main.part.Element;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author anliwei
 * @create 2020/6/10 14:49
 */
public interface ElementMapper {
    /**
     * 增加元素
     *
     * @param element
     * @return
     */
    @Insert("insert into element_table (id,name,owner,value,type,count,createTime,lastUsedTime) " +
            "values (#{id},#{name},#{owner},#{value},#{Type},#{usedCount},#{creatTime},#{lastUsedTime})")
    int addElement(Element element);

    /**
     *
     * 根据元素名称修改元素
     *
     * @param name
     * @param element
     * @return
     */
    int updateElement(String name,Element element);

    /**
     * 根据Element名称查处元素
     * @param elementName
     * @return
     */
    Element findElementByName(String elementName);

    /**
     * 根据Owner名称查处元素
     * @param ownerName
     * @return
     */
    @Select("select * from element_table WHERE owner=#{ownerName}")
    List<Element> findAllElementByOwnerName(String ownerName);



    /**
     * 根据名称删除元素
     * @param elementName
     * @return
     */
    @Delete("DELETE FROM element_table WHERE name = #{elementName}")
    int deleteElement(String elementName);


}
