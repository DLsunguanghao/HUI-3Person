package com.lanou.service.Impl;

import com.lanou.bean.Scrap;
import com.lanou.mapper.ScrapMapper;
import com.lanou.service.ScrapService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service
public class ScrapServiceimpl implements ScrapService {

    @Resource
    private ScrapMapper scrapMapper;
    //查询所有废品
    @Override
    public List<Scrap> findAllScrap() {
        return scrapMapper.findAllScrap();
    }
    //添加废品
    public void addScrap(Scrap scrap){
        scrapMapper.insert(scrap);
    }
    //验证添加废品
    //1>查询废品编号是否存在
    @Override
    public Scrap findScrapByScrapcode(String scrapcode) {
        return scrapMapper.findScrapByScrapcode(scrapcode);
    }
    //查询废品名称是否存在
    @Override
    public Scrap findScrapByScrapname(String scrapname) {
        return scrapMapper.findScrapByScrapname(scrapname);
    }
    //删除废品
    @Override
    public void deleteScrap(Integer deleteId) {
        scrapMapper.deleteScrap(deleteId);
    }

}
