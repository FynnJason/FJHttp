package com.fynnjason.fjokgo.network;

import com.blankj.utilcode.util.SPUtils;
import com.fynnjason.fjokgo.bean.BaseBean;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

/**
 * 作者：FynnJason
 * 备注：网络请求
 */

public class RequestUtils<T extends BaseBean> extends RequestHelper<T> {

    public RequestUtils(T t) {
        this.t = t;
    }

    public RequestUtils<T> params(HttpParams params) {
        this.params = params;
        return this;
    }

    public RequestUtils<T> headers(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    /*
     *自己构建的默认headers，根据项目情况修改内容
     */
    public RequestUtils<T> useDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("accessToken", SPUtils.getInstance().getString("accessToken"));
        this.headers = headers;
        return this;
    }


    /**
     * 登录
     */
    public void staffLogin(String json, RequestCallback<T> callback) {
        post(Api.STAFF_LOGIN, json, callback);
    }

    /**
     * 用户详情
     */
    public void staffDetail(RequestCallback<T> callback) {
        get(Api.STAFF_DETAIL, callback);
    }
}
