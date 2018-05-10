package com.dfst.utils;

import java.util.UUID;

/**
 * @author seven
 * @create 2018-05-06 19:00
 **/
public class CommonUitls {


    public static String createuuid() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

}
