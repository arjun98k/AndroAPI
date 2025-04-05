package com.example.apiandroid

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Activity, val productList: List<Product>)  :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var productTitle = itemView.findViewById<TextView>(R.id.productTitle)
        init {
            productTitle
        }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = productList[position]
        holder.productTitle.text = currentItem.title
    }
}
