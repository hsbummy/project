package com.example.cafe_user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cafe_user.ui.cart.CartFragment
import com.example.cafe_user.ui.home.HomeFragment
import com.example.cafe_user.ui.home.MenuRecycleItem
import com.example.cafe_user.ui.home.RecyclerCardAdapter
import com.example.cafe_user.ui.order.*
import kotlinx.android.synthetic.main.cardviewitem.*
import kotlinx.android.synthetic.main.main_card_recycle_menu.*
import kotlinx.android.synthetic.main.main_card_view_menu.*

class MainActivity : AppCompatActivity() {
    var homeview = HomeFragment()
    var cartview = CartFragment()

    val coffeefrag = CoffeeFragment()
    val dessertfrag = DessertFragment()
    val breadfrag = BreadFragment()
    val juicefrag = JuiceFragment()
    val smoothfrag = SmoothieFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_order, R.id.navigation_cart))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    fun setFragment(name:String){
        //2. Fragment객체 관리하는 관리자 객체 구함
        val fragMa = supportFragmentManager

        val fragActintent = Intent(this,HomeFragment::class.java)

        //3.Fragment 객체가 사용되고 시작될 수 있도록 - FragmentTransaction
        val transaction = fragMa.beginTransaction()
        when(name){
            "home" -> {
                startActivity(fragActintent)
            }

            "coffee" ->{
                transaction.replace(R.id.nav_host_fragment,coffeefrag)
                transaction.addToBackStack("home")
            }
            "bread" ->{
                transaction.replace(R.id.nav_host_fragment,breadfrag)
                transaction.addToBackStack("home")
            }
            "dessert" ->{
                transaction.replace(R.id.nav_host_fragment,dessertfrag)
                transaction.addToBackStack("home")
            }
            "juice" ->{
                transaction.replace(R.id.nav_host_fragment,juicefrag)
                transaction.addToBackStack("home")
            }
            "smoothie" ->{
                transaction.replace(R.id.nav_host_fragment,smoothfrag)
                transaction.addToBackStack("home")
            }
        }
        transaction.commit()
    }
}