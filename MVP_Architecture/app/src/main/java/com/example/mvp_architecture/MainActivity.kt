package com.example.mvp_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_architecture.Presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginCommunicationInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



       val loginPresenter = LoginPresenter(this)
        btnLogin.setOnClickListener{
            val username = etName.text.toString()
            val password = etPassword.text.toString()
            loginPresenter.login(username,password)
        }
    }
    override fun onSuccess(result: Boolean) {
        textView.text ="Login Success"
    }
    override fun onFailure(result: Boolean) {
        textView.text = "Login Failure"
    }
}