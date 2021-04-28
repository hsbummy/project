package com.example.cafe_user.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe_user.MainActivity
import com.example.cafe_user.ui.order.OrderActivity
import kotlinx.android.synthetic.main.main_card_view_menu.view.*


class RecyclerCardAdapter(var context: Context, var itemlayout:Int, var main_menulist: ArrayList<MenuRecycleItem>, var activity: MainActivity)
                                                        : RecyclerView.Adapter<RecyclerCardAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerCardAdapter.MyViewHolder {
        //항목으로 사용할 View 객체 생성
        val itemView = LayoutInflater.from(context).inflate(itemlayout, null)
        val myViewHolder = MyViewHolder(itemView)

        return myViewHolder
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImg = itemView.main_cardimageView
        val infotext = itemView.main_cardinfotext

    }

    //MyViewHolder에 저장된 CircleImageView 꺼내서 데이터 연결
    override fun onBindViewHolder(holder: RecyclerCardAdapter.MyViewHolder, position: Int) {

        val myPhotoImg = holder.photoImg
        val myInfoText = holder.infotext
        //ViewHolder에서 꺼낸 텍스트뷰에 데이터 연결
        myPhotoImg.setImageResource(main_menulist[position].photo)
        myInfoText.text = main_menulist[position].menu_name
        ///ViewHolder에서 꺼낸 항목을 구성한 위젯인 TextView에 이벤트 연결(이벤트연결은 ViewHolder에서 할 수 있음)



        myPhotoImg.setOnClickListener{
            when(position){
                0 -> {
                    activity.setFragment("coffee")
                }
                1 -> {
                    activity.setFragment("bread")
                }
                2 -> {
                    activity.setFragment("dessert")
                }
                3 -> {
                    activity.setFragment("juice")
                }
                4 -> {
                    activity.setFragment("smoothie")
                }
            }
        }

    }

    //RecyclerView에 출력할 데이터 갯수 리턴
    override fun getItemCount(): Int {
        return main_menulist.size
    }

}