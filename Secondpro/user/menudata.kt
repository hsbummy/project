package com.example.myapplication.user

class menudata(var menu_id : Int, var menu_name : String, var cate_id : Int, var price : Int, var menu_state : Int, var menu_title : String) {
    override fun toString(): String {
        return "menudata(menu_id=$menu_id, menu_name='$menu_name', cate_id=$cate_id, price=$price, menu_state=$menu_state, menu_title='$menu_title')"
    }
}