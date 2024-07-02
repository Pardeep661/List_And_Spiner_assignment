package com.pardeep.list_and_spiner_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var list: ArrayList<ItemData>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
       return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.item_data,parent,false)

        var itemName = view.findViewById<TextView>(R.id.ItemName)
        itemName.setText(list[position].itemName)

        var itemQty = view.findViewById<TextView>(R.id.Item_Qty)
        itemQty.setText(list[position].itemQty.toString())


        return view
    }

}
