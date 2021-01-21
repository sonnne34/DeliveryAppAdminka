package com.example.sushikitchen.models

class OrderModel {
    var date : String? = null
    var money : String? = null
    var status : String? = null
    var os : String? = null
    var order: ArrayList<MenuModelcatMenu>  = ArrayList()
    var personInfo: PersonModel? = null
}