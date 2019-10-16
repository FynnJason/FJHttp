# 说明
这里我对OkGo的用法进行二次封装。
先来看一下最终结果的调用方式，以某个项目的登录、获取用户详情两个接口举例：
1、登录
```
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
```
2.用户详情
```
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
```    
