package com.fynnjason.fjokgo.network;

import com.fynnjason.fjokgo.bean.BaseBean;

public interface RequestCallback<T extends BaseBean> {
    void onSuccess(T t);

    void onError(int errorCode, String errorMsg);
}
