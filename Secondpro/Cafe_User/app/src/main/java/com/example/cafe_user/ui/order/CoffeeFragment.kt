package com.example.cafe_user.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_user.R
import com.example.cafe_user.ui.menu.menuitem
import kotlinx.android.synthetic.main.order_coffee.*

class CoffeeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.order_coffee, container, false)
        return view
    }

    var datalist = ArrayList<menuitem>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        datalist.add(menuitem(R.drawable.americano, "아메리카노", "Caffe Americano"
            , "NO.1", 3200)
        )

        datalist.add(menuitem(R.drawable.caffelatte, "카페라떼", "Caffe Latte"
            , "BEST", 3500))

        datalist.add(menuitem(R.drawable.moca, "카페모카", "Caffe Moca"
            , "추천", 3500))

        val adapter1 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }
        val adapter2 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }
        val adapter3 = context?.let { OrderRecyclerAdapter(it, R.layout.cardviewitem,datalist) }

        val manager1 = LinearLayoutManager(context)
        manager1.orientation = LinearLayoutManager.HORIZONTAL
        coffee_recycler1.layoutManager = manager1

        val manager2 = LinearLayoutManager(context)
        manager2.orientation = LinearLayoutManager.HORIZONTAL
        coffee_recycler2.layoutManager = manager2

        val manager3 = LinearLayoutManager(context)
        manager3.orientation = LinearLayoutManager.HORIZONTAL
        coffee_recycler3.layoutManager = manager3

        coffee_recycler1.adapter = adapter1
        coffee_recycler2.adapter = adapter2
        coffee_recycler3.adapter = adapter3

    }
}
