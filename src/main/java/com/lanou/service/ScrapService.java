package com.lanou.service;

import com.lanou.bean.Scrap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */

public interface ScrapService {
    //查询所有废品
    List<Scrap> findAllScrap();
    //添加废品
    void addScrap(Scrap scrap);
    //验证添加废品
    //1>查询废品编号是否存在
    Scrap findScrapByScrapcode(String scrapcode);
    //2>查询废品名称是否存在
    Scrap findScrapByScrapname(String scrapname);
    //删除废品
    void deleteScrap(Integer deleteId);



}
