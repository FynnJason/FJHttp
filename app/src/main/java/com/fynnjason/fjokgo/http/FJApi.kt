/*
 * Copyright (C) 2019 FynnJason.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fynnjason.fjokgo.http

/**
 * 网络请求地址
 */
object FJApi {
    const val SUCCESS_CODE = 200 // 网络请求成功Code
    const val NOT_NETWORK_CODE=500 // 网络请求失败Code
    const val EXCEPTION_CODE = -1 // 网络请求异常Code

    const val BASE_URL = "http://101.206.8.9:8080" // 测试服务器地址

    const val LOGIN = "$BASE_URL/api/v1/uc/customer/login" // 登录
}