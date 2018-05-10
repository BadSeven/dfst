package com.dfst.vo;

import com.dfst.pojo.News;

import java.util.List;

/**
 * @author seven
 * @create 2018-05-06 21:45
 **/
public class NewVo {

    private int pageSize;
    private int page;//当前页面
    private int total; //总数

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<News> getListnews() {
        return listnews;
    }

    public void setListnews(List<News> listnews) {
        this.listnews = listnews;
    }

    private List<News> listnews;


}
