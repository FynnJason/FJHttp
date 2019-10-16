package com.fynnjason.fjokgo.network;


import com.blankj.utilcode.util.SPUtils;
import com.fynnjason.fjokgo.bean.BaseBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;


/**
 * 作者：FynnJason
 * 备注：统一处理 get post 请求
 * <p>
 */

@SuppressWarnings("unchecked")
class RequestHelper<T extends BaseBean> {

    T t;
    RequestCallback<T> callback;
    GetRequest<String> getRequest;
    PostRequest<String> postRequest;

    // get请求
    GetRequest<String> get(String url) {
        getRequest = OkGo.<String>get(url).tag(url);
        return getRequest;
    }

    // post请求
    PostRequest<String> post(String url) {
        postRequest = OkGo.<String>post(url).tag(url);
        return postRequest;
    }

    /*--------------------------华丽的分割线（以上部分基本不用修改）--------------------------*/

    // 解析回调，可以根据项目实际情况在统一处理某些逻辑
    StringCallback stringCallback = new StringCallback() {
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
