package com.example.sushikitchen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.dialog.addDialog
import com.example.sushikitchen.models.OrderModel
import com.example.sushikitchen.models.StatusOrderModel

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
        return OrderViewHolder(itemView= itemView)

    }

    override fun getItemCount(): Int {
        return mOrderList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is OrderViewHolder ){
            holder.bind(statusOrderModel = mOrderList[position])
        }
    }

    class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var order : TextView = itemView.findViewById(R.id.txt_number_item)
        private var time : TextView = itemView.findViewById(R.id.txt_time_item)

        fun bind (statusOrderModel: OrderModel){

            time.text = "${statusOrderModel.os}"

            itemView.setOnClickListener {


                addDialog.openAddressDialog(itemView.context, statusOrderModel)

            }
        }
    }
}