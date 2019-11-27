package com.fynnjason.fjokgo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.fynnjason.fjokgo.bean.LoginBean
import com.fynnjason.fjokgo.command.LoginCommand
import com.fynnjason.fjokgo.http.FJHttp
import com.fynnjason.fjokgo.http.FJHttpCallback
import com.google.gson.Gson

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        val command = LoginCommand()
        command.cellphone = "18308410675"
        command.pwd = "123456"

        FJHttp(LoginBean())
                .login(Gson().toJson(command))
                .execute(object : FJHttpCallback<LoginBean> {
                    override fun onSuccess(t: LoginBean, responseBody: String) {

                    }

                    override fun onError(errorCode: Int, errorMsg: String) {

                    }
                })
    }
}
