package com.fynnjason.fjokgo;

import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.fynnjason.fjokgo.bean.StaffDetailBean;
import com.fynnjason.fjokgo.bean.StaffLoginBean;
import com.fynnjason.fjokgo.json.LoginJson;
import com.fynnjason.fjokgo.network.RequestCallback;
import com.fynnjason.fjokgo.network.RequestUtils;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String mJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginJson loginJson = new LoginJson();
        loginJson.setUserName("admin");
        loginJson.setPwd("123456");

        mJson = new Gson().toJson(loginJson);

        login();
    }

    // 登录
    private void login() {
        new RequestUtils<>(new StaffLoginBean())
                .staffLogin(mJson)
                .execute(new RequestCallback<StaffLoginBean>() {
                    @Override
                    public void onSuccess(StaffLoginBean staffLoginBean) {
                        LogUtils.e(staffLoginBean.getData().getAccessToken());
                        // 保存用户token
                        SPUtils.getInstance().put("accessToken", staffLoginBean.getData().getAccessToken());
                        // 获取用户详情
                        detail();
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
    }

    // 用户详情
    private void detail() {
        new RequestUtils<>(new StaffDetailBean())
                .staffDetail()
                .execute(new RequestCallback<StaffDetailBean>() {
                    @Override
                    public void onSuccess(StaffDetailBean staffDetailBean) {
                        LogUtils.e(staffDetailBean.getData().getRealName());
                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });
    }

}
