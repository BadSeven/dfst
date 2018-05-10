package com.dfst.service;

import com.dfst.dao.NewsMapper;
import com.dfst.pojo.News;
import com.dfst.vo.NewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author seven
 * @create 2018-05-06 21:40
 **/
@Service
public class CommonService {


    @Autowired
    private NewsMapper mapper;

    public NewVo getNews(NewVo newVo) throws Exception {
        NewVo retNews = mapper.getNews(newVo);
        retNews.setTotal(mapper.getTotle());
        retNews.setPageSize(newVo.getPageSize());
        retNews.setPage(newVo.getPage());
        return retNews;
    }

    public int saveNew(News news) throws Exception{
        return mapper.insertSelective(news);
    }

    public News getNew(int id){
        return mapper.selectByPrimaryKey(id);
    }


    public List<News> getNewList() throws Exception{
        return  mapper.getNewList();
    }
    public List<News> getallNewList() throws Exception{
        return  mapper.getallNewList();
    }
}
