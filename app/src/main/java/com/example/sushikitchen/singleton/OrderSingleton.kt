package com.example.sushikitchen.singleton

import android.util.Log
import com.example.sushikitchen.models.OrderModel

object OrderSingleton {

    var basketItem : ArrayList<OrderModel> = ArrayList()

    fun addBasketItem(order: OrderModel){
        basketItem.add(order)
    }


    fun showBasket(){
        for(i in basketItem){
            var yy = i.os

            Log.d("Basket", "Items = "  + yy)
        }

    }
}