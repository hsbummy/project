package com.example.myapplication.stock

import java.sql.Date

class beandata(var storage_id : Int, var bean_name : String, var bean_count : Int, var bean_date : Date, var bean_shelf : Date, var bean_expire : Int) {
    override fun toString(): String {
        return "beandata(storage_id=$storage_id, bean_name='$bean_name', bean_count=$bean_count, bean_date=$bean_date, bean_shelf=$bean_shelf, bean_expire=$bean_expire)"
    }
}