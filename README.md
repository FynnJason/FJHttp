# 前言
Kotlin语言不难，相信具备Java基础的开发者各位，阅读源码是很容易的

# 达到的效果
- 请求成功，返回数据对象和Json字符串
- 请求失败，返回code和msg
- 链式调用

# 封装思路
在http目录下，包含一下类：
```
FJApi
FJBaseBean
FJHttp
FJHttpCallback
FJHttpHelper
FJHttpUtils
```

[FJApi](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJApi.kt) 管理网络请求的code，服务器地址，接口地址
[FJBaseBean](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJBaseBean.kt) 数据类的基类，所有数据类都需要继承该基类。PS：code和msg的变量名称可以根据实际项目修改，修改此处后会影响[FJHttpHelper](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttpHelper.kt)中对应的code和msg变量名称，所以也需要一起修改
[FJHttp](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttp.kt)构建我们项目所有的请求方法，例如登录、注册等等
[FJHttpCallback](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttpCallback.kt)接口，回调网络请求的成功和失败
[FJHttpHelper](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttpHelper.kt)封装代码最核心的地方，统一在StringCallback中处理，最终再回调到[FJHttpCallback](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttpCallback.kt)，在这个类中，开发者需要根据项目的实际情况再简单修改，例如有些项目code=401时是用户token失效，那可以在StringCallback中删除本地存储的token，或者跳转到登录界面等等
[FJHttpUtils](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJHttpUtils.kt)在Applicaition中必须初始化的工具类

# 列举登录示例，详细代码直接参考demo
首先这是成功登录返回的json字符串
```
{"code":200,"msg":"成功!","data":{"communityId":1,"token":"ekbacmmuiokk"},"status":200}
```
## 第一步：构建数据类，这里是登录，就取名叫[LoginBean](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/bean/LoginBean.kt)
```
data class LoginBean(val data: DataBean? = null) : FJBaseBean()

data class DataBean(val communityId: Int, val token: String)
```

## 第二步：在FJHttp中构建登录方法

```
class FJHttp<T : FJBaseBean>(t: T) : FJHttpHelper<T>(t) {

    // 登录
    fun login(command: String): FJHttp<T> {
        post(FJApi.LOGIN).upJson(command)
        return this
    }
}
```
所有的方法都必须返回类本身
## 第三步：在activity中调用该方法
```
FJHttp(LoginBean())
                .login(Gson().toJson(command))
                .execute(object : FJHttpCallback<LoginBean> {
                    override fun onSuccess(t: LoginBean, responseBody: String) {

                    }

                    override fun onError(errorCode: Int, errorMsg: String) {

                    }
                })
```





