package com.example.sushikitchen.models

class OrderModel (var order: String, var timeOrder: String, var dish: String, var amount: String) {
    constructor() : this("", "", "", "")
}