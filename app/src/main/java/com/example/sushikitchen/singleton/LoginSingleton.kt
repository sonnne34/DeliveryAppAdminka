package com.example.sushikitchen.singleton

object LoginSingleton {
    var login : String = ""

    fun addLogin(mLogin : String){
        login = mLogin
    }
}