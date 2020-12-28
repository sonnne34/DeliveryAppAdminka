package com.example.sushikitchen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.adapters.OrderDialogAdapter
import com.example.sushikitchen.models.StatusOrderModel

class DialogOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_order)

        var orderDialogModel : ArrayList<StatusOrderModel> = ArrayList()

        val rvOrderDialog = findViewById<RecyclerView>(R.id.rv_order_dialog)

        var orderDialogAdapter = OrderDialogAdapter()
        rvOrderDialog.adapter = orderDialogAdapter
        rvOrderDialog.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        rvOrderDialog.setHasFixedSize(true)
        orderDialogAdapter.setupDialogOrder(orderDialogList = orderDialogModel)

        val furtherDialog = findViewById<Button>(R.id.btn_further_dialog)

        val cancelDialog = findViewById<Button>(R.id.btn_cancel_dialog)

        cancelDialog.setOnClickListener {
            onBackPressed()
        }
    }
}