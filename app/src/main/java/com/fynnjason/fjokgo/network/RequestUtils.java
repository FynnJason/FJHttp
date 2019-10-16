package com.fynnjason.fjokgo.network;

import com.blankj.utilcode.util.SPUtils;
import com.fynnjason.fjokgo.bean.BaseBean;
import com.lzy.okgo.model.HttpHeaders;

/**
 * 作者：FynnJason
 * 备注：网络请求
 */

public class RequestUtils<T extends BaseBean> extends RequestHelper<T> {

    public RequestUtils(T t) {
        this.t = t;
    }

    public void execute(RequestCallback<T> callback) {
        this.callback = callback;
        if (getRequest != null)
            getRequest.execute(stringCallback);
        if (postRequest != null)
            postRequest.execute(stringCallback);
    }

    /*--------------------------华丽的分割线（以上部分基本不用修改）--------------------------*/

    // 根据项目构建默认的headers
   private HttpHeaders getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.put("accessToken", SPUtils.getInstance().getString("accessToken"));
        return headers;
    }

    // 登录
    public RequestUtils<T> staffLogin(String json) {
        post(Api.STAFF_LOGIN).upJson(json);
        return this;
    }

    // 用户详情
    public RequestUtils<T> staffDetail() {
        get(Api.STAFF_DETAIL)
                .headers(getDefaultHeaders());
        return this;
    }

    // 公司列表
    public RequestUtils<T> departmentGetCompanies(int pageNum) {
        get(Api.DEPARTMENT_GET_COMPANIES)
                .params("pageNum", pageNum)
                .params("pageSize", 20);
        return this;
    }


}
