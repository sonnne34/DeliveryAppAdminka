package com.example.sushikitchen.dialog

import android.app.Dialog
import android.widget.ListPopupWindow
import android.content.Context
import android.view.Gravity
import android.view.Window
import android.widget.Button
import com.example.sushikitchen.R
import com.example.sushikitchen.models.OrderModel


class addDialog {
    companion object{
        fun openAddressDialog(context : Context){


            val dialog = Dialog(context, R.style.CustomDialog)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.dialog_item)
            dialog.window?.setGravity(Gravity.BOTTOM)
            dialog.window?.setLayout(
                ListPopupWindow.MATCH_PARENT,
                ListPopupWindow.WRAP_CONTENT)



            var btnYES = dialog.findViewById(R.id.add_btn) as Button
            var btnNO = dialog.findViewById(R.id.cancel_btn) as Button

            btnYES.setOnClickListener {

//                ItemSingleton.addItems(item)
//
//                ItemSingleton.show()
//                val intent = Intent(context, WorkActivity::class.java)
//                context.startActivity(intent)


                dialog.cancel()

            }
            btnNO.setOnClickListener {

                dialog.cancel()
            }

            dialog.show()

        }
    }
}
