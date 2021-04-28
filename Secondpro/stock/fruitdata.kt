package com.example.myapplication.stock

import java.sql.Date

class fruitdata(var storage_id : Int, var fruit_name : String, var fruit_count : Int, var fruit_date : Date, var fruit_shelf : Date, var fruit_expire : Int) {
    override fun toString(): String {
        return "fruitdata(storage_id=$storage_id, fruit_name='$fruit_name', fruit_count=$fruit_count, fruit_date=$fruit_date, fruit_shelf=$fruit_shelf, fruit_expire=$fruit_expire)"
    }
}