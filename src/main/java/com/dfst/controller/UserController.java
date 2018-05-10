package com.dfst.controller;

import com.dfst.BaseMessage;
import com.dfst.conf.UploadProperties;
import com.dfst.pojo.User;
import com.dfst.service.UserService;
import com.dfst.utils.CommonUitls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;


/**
 * @author seven
 * @create 2018-05-06 14:19
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UploadProperties uploadProperties;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseMessage login(@RequestBody User user) {
        BaseMessage baseMessage = new BaseMessage();
        if (user == null || user.getPassword() == null || user.getName() == null) {
            baseMessage.setCode("201");
            baseMessage.setMessage("用户名/密码为空");
            logger.error("login error log");
        } else {
            try {
                User retUser = userService.login(user);
                if (retUser == null) {
                    baseMessage.setCode("202");
                    baseMessage.setMessage("未找到用户");
                    logger.debug("this is login error log");
                } else {
                    baseMessage.setCode("200");
                    baseMessage.setMessage("success");
                    baseMessage.setData(retUser);
                    logger.debug("用户登陆aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                }
            } catch (Exception e) {
                baseMessage.setCode("500");
                baseMessage.setMessage("服务器错误");
                e.printStackTrace();
                logger.error("this is login error log");
            }
        }
        return baseMessage;
    }


    @ResponseBody
    @RequestMapping(value = "/uploadIndexImage", method = RequestMethod.POST)
    public BaseMessage uploadImage(@RequestParam(value = "image") MultipartFile image,
                                   @RequestParam(value = "type") String type
                                   ) {
        Logger logger = LoggerFactory.getLogger(UserController.class);
        BaseMessage baseMessage = new BaseMessage();
        String basePath = uploadProperties.getBasePath();
        File file = new File(basePath);
        if (!file.exists()) {
            file.mkdirs();
            logger.debug("new dir");
        }
        String filename = CommonUitls.createuuid();
        String suffixName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
        String path = basePath + filename + suffixName;
        File dest = new File(path);
        try {
            image.transferTo(dest);
            logger.info("上传的文件名为{}", filename + suffixName);
            baseMessage.setMessage("上传成功");
            baseMessage.setCode("200");

        } catch (IOException e) {
            baseMessage.setMessage("上传失败");
            baseMessage.setCode("500");
            e.printStackTrace();
        }

        return baseMessage;
    }
}
