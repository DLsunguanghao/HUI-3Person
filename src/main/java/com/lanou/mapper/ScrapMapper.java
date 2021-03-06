package com.lanou.mapper;

import com.lanou.bean.Scrap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScrapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scrap record);

    int insertSelective(Scrap record);

    Scrap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scrap record);

    int updateByPrimaryKey(Scrap record);
    //查询所有废品
    List<Scrap> findAllScrap();
    //验证添加废品
    //1>查询废品编号是否存在
    Scrap findScrapByScrapcode(String scrapcode);
    //2>查询废品名称是否存在
    Scrap findScrapByScrapname(String scrapname);
    //删除废品
    void deleteScrap(@Param("deleteId")Integer deleteId);
}