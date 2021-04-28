package com.example.myapplication.user

class cartdata(var cart_num : Int, var table_id : Int, var menu_name : String, var cart_count : Int, var temp_option : Int, var size_option : Int, var cart_price : Int) {
    override fun toString(): String {
        return "cartdata(cart_num=$cart_num, table_id=$table_id, menu_name='$menu_name', cart_count=$cart_count, temp_option=$temp_option, size_option=$size_option, cart_price=$cart_price)"
    }
}