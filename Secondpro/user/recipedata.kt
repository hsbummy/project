package com.example.myapplication.user

class recipedata(var recipe_num : Int, recipe_menu : String, var item1_name : String, var item1_count : Int, var item2_name : String, var item2_count : Int,
var item3_name : String, var item3_count : Int, var item4_name : String, var item4_count : Int) {
    override fun toString(): String {
        return "recipedata(recipe_num=$recipe_num, item1_name='$item1_name', item1_count=$item1_count, item2_name='$item2_name', item2_count=$item2_count, item3_name='$item3_name', item3_count=$item3_count, item4_name='$item4_name', item4_count=$item4_count)"
    }
}