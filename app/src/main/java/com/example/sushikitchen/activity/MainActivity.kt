package com.example.sushikitchen.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sushikitchen.R
import com.example.sushikitchen.adapters.OrderAdapter
import com.example.sushikitchen.dialog.addDialog
import com.example.sushikitchen.models.OrderModel
import com.example.sushikitchen.models.StatusOrderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rvOrder : RecyclerView
    lateinit var orderAdapter : OrderAdapter
    private  var list : ArrayList<OrderModel> = ArrayList()
    private lateinit var btnNew : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvOrder = findViewById(R.id.rv_order)
        orderAdapter = OrderAdapter()
        rvOrder.adapter = orderAdapter
        rvOrder.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        rvOrder.setHasFixedSize(true)






        loaddata()

        btnNew = findViewById(R.id.btn_new_order)

        var context : Context

        btnNew.setOnClickListener{


        }





    }

    @SuppressLint("SimpleDateFormat")
    private fun loaddata() {


        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Order/" + year + "/" + month + "/" + day)

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {



                for (ds in dataSnapshot.children) {
                    val value = ds.getValue(OrderModel::class.java)!!

                    Log.d("AA", "value = " + value.os )
                    list.add(value)

                    updateAdapter(list)
                }



            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("dima", "Failed to read value.", error.toException())
            }
        })



    }

    private fun updateAdapter(modelList : ArrayList<OrderModel> ) {
        orderAdapter.setupOrder(orderList = modelList)
    }



    fun btnQuit(view: View) {
        openQuitDialog()
    }

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