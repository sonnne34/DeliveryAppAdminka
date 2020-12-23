package com.example.sushikitchen.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.activity.OrderActivity
import com.example.sushikitchen.adapters.OrderAdapter
import com.example.sushikitchen.adapters.OrderDialogAdapter
import com.example.sushikitchen.models.OrderModel


class OrderDialogFragment : Fragment() {

    private lateinit var orderDialogAdapter: OrderDialogAdapter
    private lateinit var rvOrderDialog: RecyclerView
    private  var orderDialogModel : ArrayList<OrderModel> = ArrayList()
    private lateinit var furtherDialog: Button
    private lateinit var cancelDialog: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var root = inflater.inflate(R.layout.fragment_order_dialog, container, false)

        rvOrderDialog = root.findViewById(R.id.rv_order_dialog)
        orderDialogAdapter = OrderDialogAdapter()
        rvOrderDialog.adapter = orderDialogAdapter
        rvOrderDialog.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvOrderDialog.setHasFixedSize(true)

        furtherDialog = root.findViewById(R.id.btn_further_dialog)
        cancelDialog = root.findViewById(R.id.btn_cancel_dialog)

        var d = OrderModel()
        d.dish = "Банана"
        var dd = OrderModel()
        dd.dish = "Апельсинамана"
        orderDialogModel.add(d)
        orderDialogModel.add(dd)

        setupDialogAdapter(orderDialogModel)

        btnFurther()
        btnCancel()

        return root
    }

    private fun setupDialogAdapter(modelList : ArrayList<OrderModel> ) {
        orderDialogAdapter.setupDialogOrder(orderDialogList = modelList)
    }

    private fun btnFurther() {
        furtherDialog.setOnClickListener {

        }
    }

    private fun btnCancel() {
        furtherDialog.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            startActivity(intent)
        }
    }

}