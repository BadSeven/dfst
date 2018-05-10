package com.dfst.controller;

import com.baidu.ueditor.ActionEnter;
import com.dfst.BaseMessage;
import com.dfst.pojo.News;
import com.dfst.service.CommonService;
import com.dfst.vo.NewVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


/**
 * @author seven
 * @create 2018-05-06 19:11
 **/
@Controller
public class CommonController {

    @Autowired
    private CommonService commonService;

    Logger logger = LoggerFactory.getLogger(CommonController.class);

    @ResponseBody
    @RequestMapping(value = "/getNews", method = RequestMethod.POST)
    public BaseMessage getNews(@RequestBody NewVo newVo) {
        BaseMessage baseMessage = new BaseMessage();
        try {
            NewVo retNews = commonService.getNews(newVo);
            baseMessage.setCode("200");
            baseMessage.setMessage("success");
            baseMessage.setData(retNews);
        } catch (Exception e) {
            baseMessage.setCode("500");
            baseMessage.setMessage("服务器异常");
            logger.error("服务器异常");
        }
        return baseMessage;
    }


    @RequestMapping("/")
    private String showPage() {
        return "index";
    }

    @RequestMapping(value = "/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = "/saveNew", method = RequestMethod.POST)
    public BaseMessage saveNews(@RequestBody News news) {
        BaseMessage baseMessage = new BaseMessage();
        if (news == null) {
            return new BaseMessage("200", "传出参数错误，请联系管理员", null);
        } else {
            try {
                commonService.saveNew(news);
                baseMessage.setMessage("保存成功");
                baseMessage.setCode("200");
            } catch (Exception e) {
                baseMessage.setMessage("保存失败服务器异常请联系管理员");
                baseMessage.setCode("200");
            }
            return baseMessage;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/editNew", method = RequestMethod.GET)
    public BaseMessage editNew(@RequestParam(value = "id") int id) {
        BaseMessage baseMessage = new BaseMessage();
        if (id < 0) {
            return new BaseMessage("200", "传出参数错误，请联系管理员", null);
        } else {
            News news = commonService.getNew(id);
            if (news == null) {
                return new BaseMessage("200", "数据有误,请联系管理员", null);
            } else {

                baseMessage.setCode("200");
                baseMessage.setMessage("success");
                baseMessage.setData(news);
            }
            return baseMessage;
        }
    }

    @RequestMapping("/login")
    private String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/getNewList", method = RequestMethod.POST)
    public BaseMessage getNewList() {
        BaseMessage baseMessage = new BaseMessage();
        try {
            List<News> newsList = commonService.getNewList();
            baseMessage.setData(newsList);
            baseMessage.setMessage("success");
            baseMessage.setCode("200");
        } catch (Exception e) {
            baseMessage.setMessage("保存失败服务器异常请联系管理员");
            baseMessage.setCode("200");
        }
        return baseMessage;
    }

    @ResponseBody
    @RequestMapping(value = "/getallNewList", method = RequestMethod.POST)
    public BaseMessage getallNewList() {
        BaseMessage baseMessage = new BaseMessage();
        try {
            List<News> newsList = commonService.getallNewList();
            baseMessage.setData(newsList);
            baseMessage.setMessage("success");
            baseMessage.setCode("200");
        } catch (Exception e) {
            baseMessage.setMessage("保存失败服务器异常请联系管理员");
            baseMessage.setCode("200");
        }
        return baseMessage;
    }


    @RequestMapping("/article_con")
    private String article(@RequestParam(value = "id") int id) {
        System.out.println(id);
        return "article_con";
    }

    /**
     * 获取id
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getNewById", method = RequestMethod.GET)
    public BaseMessage getNewById(@RequestParam(value = "id") int id) {
        BaseMessage baseMessage = new BaseMessage();
        try {
            baseMessage.setData(commonService.getNew(id));
            baseMessage.setMessage("success");
            baseMessage.setCode("200");
        } catch (Exception e) {
            baseMessage.setMessage(e.getMessage());
            baseMessage.setCode("500");
        }
        return baseMessage;

    }
}
