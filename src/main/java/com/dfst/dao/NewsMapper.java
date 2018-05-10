package com.dfst.dao;

import com.dfst.pojo.News;
import com.dfst.vo.NewVo;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    NewVo getNews(NewVo newVo) throws Exception;

    int getTotle() throws Exception;

    public List<News> getNewList() throws Exception;

    public List<News> getallNewList() throws Exception;
}