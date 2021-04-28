package com.example.cafe_user.ui.order

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.cafe_user.MainActivity
import com.example.cafe_user.R
import com.example.cafe_user.ui.home.HomeFragment
import com.example.cafe_user.ui.order.*
import kotlinx.android.synthetic.main.cardviewitem.*
import kotlinx.android.synthetic.main.order_screen.*

class OrderActivity : AppCompatActivity(){
    var CoffeeView: CoffeeFragment? = null
    var JuiceView: JuiceFragment? = null
    var SmoothieView: SmoothieFragment? = null
    var BreadView: BreadFragment? = null
    var DessertView: DessertFragment? = null

    val fragMainActintent = Intent(this, MainActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_screen)


        CoffeeView = CoffeeFragment()
        JuiceView = JuiceFragment()
        SmoothieView = SmoothieFragment()
        BreadView = BreadFragment()
        DessertView = DessertFragment()

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.order_menu_fragment, CoffeeView!!)
    }

    fun category_click(view: View) {
        setFragment(view.getTag().toString())
    }

    fun setFragment(tag: String) {
        var category_manager = supportFragmentManager
        var transaction = category_manager.beginTransaction()
        when (tag) {
            "1" -> transaction.replace(R.id.order_menu_fragment, CoffeeView!!)
            "2" -> transaction.replace(R.id.order_menu_fragment, JuiceView!!)
            "3" -> transaction.replace(R.id.order_menu_fragment, SmoothieView!!)
            "4" -> transaction.replace(R.id.order_menu_fragment, BreadView!!)
            "5" -> transaction.replace(R.id.order_menu_fragment, DessertView!!)
        }
        transaction.commit()
    }

    override fun onBackPressed() {
        startActivity(fragMainActintent)
    }

}