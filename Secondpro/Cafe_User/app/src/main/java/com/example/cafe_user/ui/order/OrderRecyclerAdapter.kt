package com.example.cafe_user.ui.order

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe_user.ui.cart.CartFragment
import com.example.cafe_user.ui.menu.menuitem
import kotlinx.android.synthetic.main.cardviewitem.view.*


class OrderRecyclerAdapter(var context: Context, var itemLayout: Int, var datalist:ArrayList<menuitem>)
    :RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewHolder>() {


    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var menuimg = itemView.menu_image
        var kor_menu = itemView.menu_kor
        var eng_menu = itemView.menu_eng
        var detail = itemView.menu_detail
        var price = itemView.price
        var btn = itemView.btn_add_cart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemLayout,null)
        val orderViewHolder = OrderViewHolder(itemView)
        return orderViewHolder
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        var menuimg = holder.menuimg
        menuimg.setImageResource(datalist[position].menuimg!!)
        var kor = holder.kor_menu
        kor.text = datalist[position].kor_title!!
        var eng = holder.eng_menu
        eng.text = datalist[position].eng_title!!
        var detail = holder.detail
        detail.text = datalist[position].menu_detail!!
        var price = holder.price
        price.text = datalist[position].price.toString()!!
        var btn = holder.btn
        btn.setOnClickListener {
            Toast.makeText(context, "장바구니에 담겼습니다.", Toast.LENGTH_LONG).show()
        }
    }
}