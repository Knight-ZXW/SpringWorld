package com.zous.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Created by zhuoxiuwu on 2017/3/11.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result<T> {
    /**
     * 封装json对象，所有返回结果都使用它
     */

    private boolean success;// 是否成功标志

    @JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.WRAPPER_OBJECT)
    @JsonSerialize()
    private T data;// 成功时返回的数据

    private String error;// 错误信息

    private String message;//消息

    public Result() {
    }

    public Result(T data) {
        this(true, data);
    }

    // 成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    // 错误时的构造器
    public Result(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    @JsonProperty()
    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Result<T> setMessage(String message){
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult [success=" + success + ", data=" + data + ", error=" + error + "]";
    }


    public static <T> Result<T> ok(T data) {
        return new Result<T>(data);
    }

    public static Result ok() {
        return new Result(null);
    }


    public static <T> Result<T> ok(T data, String message) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>(false, message);
    }

}
