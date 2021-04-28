package com.example.cafe_admin.ui.store

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stock_item_list.view.*

class StorageItemAdapter(var context: Context, var itemLayout: Int, var datalist: ArrayList<SubCartList>)
    : RecyclerView.Adapter<StorageItemAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.item_name
        val itemCount = itemView.item_count
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemLayout,null)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var itemTextView = holder.itemName
        var itemCountView = holder.itemCount
        itemTextView.text = datalist[position].itemName
        itemCountView.text = datalist[position].itemCount.toString()
    }
}