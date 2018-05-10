package com.dfst;

/**
 * @author seven
 * @create 2018-05-06 14:20
 **/
public class BaseMessage {

    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseMessage(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseMessage() {
    }
}
