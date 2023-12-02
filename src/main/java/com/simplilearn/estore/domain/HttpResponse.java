package com.simplilearn.estore.domain;

import java.util.List;

public class HttpResponse<T> {

    Integer code;
    String message;
    List<T> data;

    public HttpResponse() {
    }

    public HttpResponse(Integer code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /*
     * The Getter methods are necessary if you plan to return
     * an object of this class from the controller. Otherwise,
     * you will get a runtime error when you return the object.
     */
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<T> getData() {
        return data;
    }




}
