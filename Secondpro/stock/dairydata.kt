package com.example.myapplication.stock

import java.sql.Date

class dairydata(var storage_id : Int, var dairy_name : String, var dairy_count : Int, var dairy_date : Date, var dairy_shelf : Date, var dairy_expire : Int) {
    override fun toString(): String {
        return "dairydata(storage_id=$storage_id, dairy_name='$dairy_name', dairy_count=$dairy_count, dairy_date=$dairy_date, dairy_shelf=$dairy_shelf, dairy_expire=$dairy_expire)"
    }
}