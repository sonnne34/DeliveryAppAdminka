package com.example.sushikitchen.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.adapters.OrderAdapter
import com.example.sushikitchen.models.OrderModel

class OrderActivity : AppCompatActivity() {

    lateinit var rvOrder : RecyclerView
    lateinit var orderAdapter : OrderAdapter
    private  var orderModel : ArrayList<OrderModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        rvOrder = findViewById(R.id.rv_order)
        orderAdapter = OrderAdapter()
        rvOrder.adapter = orderAdapter
        rvOrder.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        rvOrder.setHasFixedSize(true)

        var or = OrderModel()
        or.order = "1"
        var ff = OrderModel()
        ff.order = "2"
        orderModel.add(or)
        orderModel.add(ff)

        setupAdapter(orderModel)

    }

    private fun setupAdapter(modelList : ArrayList<OrderModel> ) {
        orderAdapter.setupOrder(orderList = modelList)
    }

    fun btnQuit(view: View) {
        openQuitDialog()
    }
    fun btnNewOrder(view: View) {}
    fun btnCookOrder(view: View) {}
    fun btnDoneOrder(view: View) {}

    override fun onBackPressed() {
//        super.onBackPressed()
        openQuitDialog()
    }

    private fun openQuitDialog() {
        val quitDialog = AlertDialog.Builder(
            this)
        quitDialog.setTitle("Выход")
        quitDialog.setTitle("Вы уверенны, что хотите выйти?")
        quitDialog.setPositiveButton("Да"
        ) { dialog, which ->
            val intent = Intent(applicationContext, EmailPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
        quitDialog.setNegativeButton("Ой, нет!"
        ) { dialog, which -> }
        quitDialog.show()
    }
}