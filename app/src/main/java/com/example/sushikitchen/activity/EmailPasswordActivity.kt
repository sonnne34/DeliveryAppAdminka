package com.example.sushikitchen.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sushikitchen.R
import com.google.firebase.auth.FirebaseAuth


class EmailPasswordActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    lateinit var txtUserName: EditText
    lateinit var txtPassword: EditText
    lateinit var btnLogin: Button
    lateinit var pbLoading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_password)

        // инициализируем FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        txtUserName = findViewById(R.id.username)
        txtPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.login)
        pbLoading = findViewById(R.id.loading)

        loginUserAccount()

    }


    fun loginUserAccount() {
        // слушаем кнопочку "вход"
        btnLogin.setOnClickListener {

            // берём значения EditText
            var email = txtUserName.getText().toString()
            var password = txtPassword.getText().toString()

            // проверяем правильность ввода адреса электронной почты и пароля
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext,
                    "Введите корректный Email, Please",
                    Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(applicationContext,
                    "Введите корректный пароль, Please",
                    Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }

            // показываем ProgressBar
            pbLoading.visibility = View.VISIBLE;

            // вход существующего пользователя
            mAuth?.signInWithEmailAndPassword(email, password)
                ?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        // если всё успешненько
                        Toast.makeText(applicationContext,
                            "Login successful!!",
                            Toast.LENGTH_LONG)
                            .show()

                        // скрываем ProgressBar
                        pbLoading.visibility = View.GONE;

                        // переходим к сл. активити
                        val intent = Intent(applicationContext, OrderActivity::class.java)
                        startActivity(intent)
                    }

                    else {

                        // если нет, то капец кто-то криворукий
                        Toast.makeText(applicationContext,
                            "Ошибочка вышла",
                            Toast.LENGTH_LONG)
                            .show();

                        // скрываем индикатор ProgressBar
                        pbLoading.visibility = View.GONE;
                    }
                }
        }
    }

}

