package com.example.cafe_user.ui.order

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.*
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.cafe_user.MainActivity
import com.example.cafe_user.R
import kotlinx.android.synthetic.main.activity_o_state.*
import kotlin.concurrent.thread

class OState : Fragment() {
    var datalist = ArrayList<HashMap<String, Any>>()
    var progressVal:Int = 0
    lateinit var handler1: Handler

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_o_state, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var item = HashMap<String, Any>()
        item["menu_img"] = R.drawable.img01
        item["menu_name"] = "카페모카"
        item["menu_option"] = "샷 추가"
        item["menu_pickup"] = "테이크아웃"
        item["menu_count"] = "6"
        item["price"] = "6000"
        datalist.add(item)

        item = HashMap<String, Any>()
        item["menu_img"] = R.drawable.img01
        item["menu_name"] = "카페라떼"
        item["menu_option"] = "샷 추가"
        item["menu_pickup"] = "매장"
        item["menu_count"] = "7"
        item["price"] = "7000"
        datalist.add(item)

        val adapter = SimpleAdapter(activity as MainActivity, datalist, R.layout.order_state_row,
                arrayOf("menu_img", "menu_name", "menu_option", "menu_pickup",
                        "menu_count", "price"),
                intArrayOf(R.id.myimg, R.id.txtcust1, R.id.txtcust2, R.id.txtcust3,
                        R.id.txtcust4, R.id.pricecust))

        state_list.adapter = adapter
        handler1 = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                order_progress.incrementProgressBy(1)
                if (progressVal == 50){
                    order_state_text.text = "음료 만드는 중"
                    detail_msg.text = "직원이 열심히 만드는 중"
                    state_img.setImageResource(R.drawable.wait)
                }else if (progressVal == 100){
                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.complete)
                    order_state_text.text = "주문이 완료 되었습니다."
                    detail_msg.text = "음료가 완성되었습니다."
                    state_img.setImageResource(R.drawable.complete)
                    var builder = NotificationCompat.Builder(activity as MainActivity, "1111")
                            .setSmallIcon(android.R.drawable.ic_notification_overlay)
                            .setContentTitle("주문완료")
                            .setContentText("커피 받아가세요~~~~~")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setLargeIcon(bitmap)
                            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS)
                    val style = NotificationCompat.BigPictureStyle(builder)
                    style.bigPicture(bitmap)
                    builder.setStyle(style)
                    createNotiChannel(builder, "1111")
                }
            }
        }
        test.setOnClickListener {
            thread {
                for (i in 1..100){
                    progressVal = i
                    SystemClock.sleep(100)
                    handler1.sendMessage(handler1.obtainMessage())
                }
            }
        }
    }
    fun createNotiChannel(builder : NotificationCompat.Builder, id : String) {
        //낮은 버전의 사용자에 대한 설정
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, "mynetworkchannel", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(Integer.parseInt(id), builder.build())
        } else {
            //이전 버전인 경우
            val notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(Integer.parseInt(id), builder.build())
        }
    }

}