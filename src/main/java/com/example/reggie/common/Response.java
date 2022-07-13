package com.example.reggie.common;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class Response<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map<String, Object> map = new HashMap<>(); //动态数据

    public static <T> Response<T> success(T object) {
        Response<T> r = new Response<>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> Response<T> error(String msg) {
        Response<T> r = new Response<>();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public Response<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
