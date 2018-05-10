package com.dfst.service;

import com.dfst.BaseMessage;
import com.dfst.dao.userMapper;
import com.dfst.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author seven
 * @create 2018-05-06 16:20
 **/
@Service
public class UserService {
    @Autowired
    private userMapper mapper;

    public User login(User user) throws Exception {
        return mapper.selectUserByNP(user);
    }


}
