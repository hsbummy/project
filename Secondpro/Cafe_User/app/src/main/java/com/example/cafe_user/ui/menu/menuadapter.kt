package com.example.cafe_user.ui.menu

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe_user.ui.cart.CartFragment
import com.example.cafe_user.ui.cart.CartItems
import kotlinx.android.synthetic.main.cardviewitem.view.*

class menuadapter (var context : Context, var itemlayout : Int, var datalist : ArrayList<menuitem>)
    : RecyclerView.Adapter<menuadapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(context).inflate(itemlayout, null)
        val myviewholder = MyViewHolder(itemview)
        return myviewholder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var menuimg = holder.menuimg
        menuimg.setImageResource(datalist[position].menuimg!!)
        var kor = holder.kor_menu
        kor.text = datalist[position].kor_title!!
        var eng = holder.eng_menu
        eng.text = datalist[position].eng_title!!
        var detail = holder.detail
        detail.text = datalist[position].menu_detail!!
        var price = holder.price
        price.text = datalist[position].price.toString()

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var menuimg = itemview.menu_image
        var kor_menu = itemview.menu_kor
        var eng_menu = itemview.menu_eng
        var detail = itemview.menu_detail
        var price = itemview.price
    }
}