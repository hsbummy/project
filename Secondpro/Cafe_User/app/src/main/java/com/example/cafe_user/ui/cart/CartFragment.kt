package com.example.cafe_user.ui.cart



import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.activity_cart.*
import androidx.fragment.app.Fragment
import com.example.cafe_user.MainActivity
import com.example.cafe_user.ui.payment.Payment
import com.example.fragment.recycler.SwipeListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_swipe.*


class CartFragment : Fragment() {

    var datalist = ArrayList<CartItems>()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_cart, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // MenuDetail에서 직접 받은 data

//        val data = intent
//        val name = data.getStringExtra("kor_name")
//        val temp = data.getStringExtra("temp")
//        val size = data.getStringExtra("size")


        // 임시 data
        datalist.add(CartItems(R.drawable.ic_launcher_background, "아메리카노", "ame", "hot", 1, 5000))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "카페라뗴", "latte", "ice", 2, 5500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "초코라떼", "choco", "ice", 1, 5500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "딸기쥬스", "strawberry", "ice", 1, 6500))
        datalist.add(CartItems(R.drawable.ic_launcher_background, "블루베리스무디", "blueberry", "ice", 1, 6500))


        val cart_adapter = SwipeListAdapter(activity as MainActivity, R.layout.item_swipe, datalist)
        val manager = LinearLayoutManager(activity as MainActivity)

        manager.orientation = LinearLayoutManager.VERTICAL
        cart_recycler.layoutManager = manager
        cart_recycler.adapter = cart_adapter

        // 결제정보 Payment로 넘기는 intent
        btn_payment.setOnClickListener {

            val intent = Intent(activity as MainActivity, Payment::class.java).apply{
                putExtra("table_no", 1)
                putExtra("price", total_txt.text.toString().toInt())
            }
            startActivity(intent)
        }
    }
}

