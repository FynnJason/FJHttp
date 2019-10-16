package com.fynnjason.fjokgo.network;


import com.fynnjason.fjokgo.bean.BaseBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

/**
 * 作者：FynnJason
 * 备注：统一处理 get post 请求
 * <p>
 */

@SuppressWarnings("unchecked")
class RequestHelper<T extends BaseBean> {

    T t;
    HttpParams params;
    HttpHeaders headers;

    // post请求
    void post(String url, String json, final RequestCallback<T> callback) {
        this.callback = callback;
        OkGo.<String>post(url)
                .tag(url)
                .params(params)
                .headers(headers)
                .upJson(json)
                .execute(stringCallback);
    }

    // get请求
    void get(String url, final RequestCallback<T> callback) {
        this.callback = callback;
        OkGo.<String>get(url)
                .tag(url)
                .params(params)
                .headers(headers)
                .execute(stringCallback);
    }

    // 请求回调
    private RequestCallback<T> callback;

    // 解析回调
    private StringCallback stringCallback = new StringCallback() {
        @Override
        public void onSuccess(Response<String> response) {
            try {
                Object object = new Gson().fromJson(response.body(), t.getClass());
                if (((T) object).getCode() == Api.SUCCESS) {
                    // 请求成功
                    callback.onSuccess((T) object);
                } else {
                    // 请求失败
                    callback.onError(((T) object).getCode(), ((T) object).getMsg());
                }
            } catch (Exception e) {
                // 解析错误
                callback.onError(Api.EXCEPTION, e.getMessage());
            }
        }

        @Override
        public void onError(Response<String> response) {
            // 网络错误
            callback.onError(response.code(), "网络连接失败");
        }
    };
}
