package com.example.apiandroid

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dummyjson.com/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProducts()

        retrofitData.enqueue(object : Callback<Mydata?> {
            override fun onResponse(p0: Call<Mydata?>, p1: Response<Mydata?>) {
                // api call succesfull
                var responseBody = p1.body()
                val productList = responseBody?.products!!

                val collectDataInSB = StringBuilder()
                for (myData in productList) {
                    collectDataInSB.append(myData.title + " ")

                }
                val tv = findViewById<TextView>(R.id.textView)
                tv.text = collectDataInSB

            }

            override fun onFailure(p0: Call<Mydata?>, p1: Throwable) {
                Log.d("Main Activity", "onFailure: " + p1.message)
            }
        })

    }
}