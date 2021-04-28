package com.example.myapplication.user

class buydata(var buy_id : Int, var cart_id : Int, var table_id : Int, var menu_name2 : String, var payment_price : Int) {
    override fun toString(): String {
        return "buydata(buy_id=$buy_id, cart_id=$cart_id, table_id=$table_id, menu_name2='$menu_name2', payment_price=$payment_price)"
    }
}