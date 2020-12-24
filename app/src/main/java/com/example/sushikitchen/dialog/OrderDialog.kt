package com.sushi.Sushi.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.widget.Button
import android.widget.ListPopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.adapters.OrderDialogAdapter
import com.example.sushikitchen.models.StatusOrderModel

class OrderDialog {
    companion object {
        fun openDialog(context: Context, fileMenu: StatusOrderModel) {


            val dialog = Dialog(context, R.style.CustomDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.order_dialog)
            dialog.window?.setGravity(Gravity.BOTTOM)
            dialog.window?.setLayout(
                ListPopupWindow.MATCH_PARENT,
                ListPopupWindow.MATCH_PARENT)

            var orderDialogModel : ArrayList<StatusOrderModel> = ArrayList()

            val rvOrderDialog = dialog.findViewById(R.id.rv_order_dialog) as RecyclerView

            var orderDialogAdapter: OrderDialogAdapter = OrderDialogAdapter()
            rvOrderDialog.adapter = orderDialogAdapter
            rvOrderDialog.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            rvOrderDialog.setHasFixedSize(true)
            orderDialogAdapter.setupDialogOrder(orderDialogList = orderDialogModel)

            val furtherDialog = dialog.findViewById(R.id.btn_further_dialog) as Button

            val cancelDialog = dialog.findViewById(R.id.btn_cancel_dialog) as Button

            cancelDialog.setOnClickListener {
                dialog.cancel()


            }
        }
    }
}