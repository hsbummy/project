package com.example.myapplication.stock

import java.sql.Date

class macarondata(var storage_id : Int, var mac_name : String, var mac_count : Int, var mac_date : Date, var mac_shelf : Date, var mac_expire : Int) {
    override fun toString(): String {
        return "macarondata(storage_id=$storage_id, mac_name='$mac_name', mac_count=$mac_count, mac_date=$mac_date, mac_shelf=$mac_shelf, mac_expire=$mac_expire)"
    }
}