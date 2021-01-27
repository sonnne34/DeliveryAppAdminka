package com.example.sushikitchen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.adapters.OrderWorkAdapter

class WorkActivity : AppCompatActivity()  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderWorkAdapter: OrderWorkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        recyclerView = findViewById(R.id.recycler_view)
        orderWorkAdapter = OrderWorkAdapter()
        recyclerView.adapter = orderWorkAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
//        var list = ItemSingleton.item

//        update(list)
    }

//    private fun update(list : ArrayList<OrderModel>) {
//        orderWorkAdapter.setupWorkOrder(list)
//    }
}