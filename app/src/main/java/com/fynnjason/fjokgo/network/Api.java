package com.fynnjason.fjokgo.network;



public class Api {

    // 请求成功
    public static final int SUCCESS = 200;
    // 解析错误
    public static final int EXCEPTION = -100;


    // 服务器地址
    private static final String BASE_URL = "http://192.168.2.13:9090";

    // 登录
    public static final String STAFF_LOGIN = BASE_URL + "/staff/login";
    // 用户详情
    public static final String STAFF_DETAIL = BASE_URL + "/staff/detail";

}
