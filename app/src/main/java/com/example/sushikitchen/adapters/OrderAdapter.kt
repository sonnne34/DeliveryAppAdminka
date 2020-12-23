package com.example.sushikitchen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.models.OrderModel

class OrderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOrderList: ArrayList<OrderModel> = ArrayList()

    fun setupOrder(orderList: ArrayList<OrderModel>){
        mOrderList.clear()
        mOrderList.addAll(orderList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView  = layoutInflater.inflate(R.layout.item_order,parent,false)
        return BasketViewHoldel(itemView= itemView)

    }

    override fun getItemCount(): Int {
        return mOrderList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is BasketViewHoldel ){
            holder.bind(orderModel = mOrderList[position])
        }
    }

    class BasketViewHoldel(itemView: View): RecyclerView.ViewHolder(itemView){
        private var order : TextView = itemView.findViewById(R.id.txt_number_item)
        private var time : TextView = itemView.findViewById(R.id.txt_time_item)

        fun bind (orderModel: OrderModel){
            order.text = orderModel.order
            time.text = "${orderModel.timeOrder}"


        }
    }
}