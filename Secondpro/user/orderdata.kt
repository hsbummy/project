package com.example.myapplication.user

class orderdata(var order_id : Int, var cart_id : Int, var table_id : Int, var menu_name2 : String, var emp_id : Int) {
    override fun toString(): String {
        return "orderdata(order_id=$order_id, cart_id=$cart_id, table_id=$table_id, menu_name2='$menu_name2', emp_id=$emp_id)"
    }
}