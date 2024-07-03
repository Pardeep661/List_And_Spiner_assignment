package com.pardeep.list_and_spiner_assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var list : ArrayList<MyData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(var view : View) : RecyclerView.ViewHolder(view){
        var item_name = view.findViewById<TextView>(R.id.ItemName)
        var item_qty = view.findViewById<TextView>(R.id.Item_Qty)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var current_item_name = list[position].item_name
        holder.item_name.setText(current_item_name)



        var current_item_qty = list[position].item_qty.toString()
        holder.item_qty.setText(current_item_qty)

    }

}
