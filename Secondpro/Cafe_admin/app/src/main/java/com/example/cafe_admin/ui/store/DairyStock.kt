package com.example.cafe_admin.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_admin.R
import kotlinx.android.synthetic.main.coffee_stock.*
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.dairy_stock.*

class DairyStock : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dairy_stock,container,false)
        return view
    }
    val datalist = ArrayList<SubCartList>()
    var nameList = ArrayList<String>()
    var countList = ArrayList<Int>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // DataList 생성
        val getItemList = arguments
        if (getItemList != null) {
            nameList = getItemList.getStringArrayList("dairy") as ArrayList<String>
            countList = getItemList.getIntegerArrayList("count") as ArrayList<Int>
        }

        for (i in 0 until nameList.size) {
            val dao = SubCartList(nameList[i],countList[i])
            datalist.add(dao)
        }

        val adapter2 = context?.let { StorageItemAdapter(it,R.layout.stock_item_list,datalist) }

        val manager2 = LinearLayoutManager(context)
        manager2.orientation = LinearLayoutManager.VERTICAL
        dairy_item_list.layoutManager = manager2

        dairy_item_list.adapter = adapter2
    }
}