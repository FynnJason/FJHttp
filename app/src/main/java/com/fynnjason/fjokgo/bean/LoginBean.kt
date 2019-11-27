package com.fynnjason.fjokgo.bean

import com.fynnjason.fjokgo.http.FJBaseBean


data class LoginBean(val data: DataBean? = null) : FJBaseBean()

data class DataBean(val communityId: Int, val token: String)