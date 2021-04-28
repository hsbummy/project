package com.example.myapplication.stock

import java.sql.Date

class dessertdata(var storage_id : Int, var dessert_name : String, var dessert_count : Int, var dessert_date : Date, var dessert_shelf : Date, var dessert_expire : Int) {
    override fun toString(): String {
        return "dessertdata(storage_id=$storage_id, dessert_name='$dessert_name', dessert_count=$dessert_count, dessert_date=$dessert_date, dessert_shelf=$dessert_shelf, dessert_expire=$dessert_expire)"
    }
}