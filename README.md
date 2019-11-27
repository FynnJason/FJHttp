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
以上6个类，又可分为开发者需要关注的和无需关心两大类

###### 需要关注的类
[FJApi](https://github.com/FynnJason/FJHttp/blob/kotlin/app/src/main/java/com/fynnjason/fjokgo/http/FJApi.kt) 管理网络请求的code，服务器地址，接口地址



