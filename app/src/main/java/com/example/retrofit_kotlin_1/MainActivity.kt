package com.example.retrofit_kotlin_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var responseList = listOf<ResponseItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiInterface::class.java)
        apiClient.getPosts(etPostId.text.toString().toInt())
            .enqueue(object : Callback<List<ResponseItem>> {
                override fun onResponse(
                    call: Call<List<ResponseItem>>,
                    response: Response<List<ResponseItem>>
                ) {
                    responseList = response.body()!!
                    setAdapter()
                }

                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                }

            })

    }

    private fun setAdapter() {
        val adapter = Adapter(responseList)
        //val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}