package com.example.sushikitchen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.models.OrderModel

class OrderDialogAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mOrderDialogList: ArrayList<OrderModel> = ArrayList()

    fun setupDialogOrder(orderDialogList: ArrayList<OrderModel>){
        mOrderDialogList.clear()
        mOrderDialogList.addAll(orderDialogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView  = layoutInflater.inflate(R.layout.item_order_dialog,parent,false)
        return BasketViewHoldel(itemView= itemView)

    }

    override fun getItemCount(): Int {
        return mOrderDialogList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is BasketViewHoldel ){
            holder.bind(orderModel = mOrderDialogList[position])
        }
    }

    class BasketViewHoldel(itemView: View): RecyclerView.ViewHolder(itemView){
        private var dish : TextView = itemView.findViewById(R.id.txt_dish_order_dialog)
        private var amount : TextView = itemView.findViewById(R.id.txt_amount_order_dialog)

        fun bind (orderModel: OrderModel){
            dish.text = orderModel.dish
            amount.text = "${orderModel.amount}"


        }
    }


}