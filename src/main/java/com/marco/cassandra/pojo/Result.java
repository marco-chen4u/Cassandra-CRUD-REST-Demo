package com.marco.cassandra.pojo;

import java.io.Serializable;

/**
 * Universal Response Entity class
 */
public class Result implements Serializable {
    // fields
    private boolean flag;
    private String message;
    private Object data;

    // constructor
    public Result() {

    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    // methods
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
}
