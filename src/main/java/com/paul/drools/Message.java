package com.paul.drools;

import java.io.Serializable;

/**
 * Created by hzzhouminmin on 2018/7/30.
 */
public class Message implements Serializable {

    public static final Integer HELLO = 1;

    public static final Integer GOODBYE = 2;

    private String message;

    private Integer status;

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
