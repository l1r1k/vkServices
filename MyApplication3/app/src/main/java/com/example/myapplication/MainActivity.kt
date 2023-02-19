package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var apiInterface: ApiInterface
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.servicesView)
        apiInterface = Common.apiInterface
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        apiInterface.getServicesList().enqueue(object: Callback<ServicesArray>{
            override fun onFailure(call: Call<ServicesArray>, t: Throwable) {
                Toast.makeText(baseContext, "Ошибка", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ServicesArray>, response: Response<ServicesArray>) {
                adapter = RecyclerViewAdapter(baseContext, response.body() as ServicesArray)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }
        })
    }
}