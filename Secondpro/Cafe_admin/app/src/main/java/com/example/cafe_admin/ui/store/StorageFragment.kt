package com.example.cafe_admin.ui.store

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.cafe_admin.R
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.storage_menu_test.*
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class StorageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.storage_menu_test,container, false)
        return view
    }
    // 그래프 자료를 담는 변수
    val coffeeEntries = ArrayList<BarEntry>()
    val coffeeCounts = ArrayList<Float>()
    val dairyEntries = ArrayList<BarEntry>()
    val dairyCounts = ArrayList<Float>()
    val dessertEntries = ArrayList<BarEntry>()
    val dessertCounts = ArrayList<Float>()
    val fruitEntries = ArrayList<BarEntry>()
    val fruitCounts = ArrayList<Float>()
    val macaronEntries = ArrayList<BarEntry>()
    val macaronCounts = ArrayList<Float>()

    // 하위 프래그먼트로 보낼 변수
    val coffeeItem = ArrayList<String>()
    val coffeeCountInt = ArrayList<Int>()
    val dairyItem = ArrayList<String>()
    val dairyCountInt = ArrayList<Int>()
    val dessertItem = ArrayList<String>()
    val dessertCountInt = ArrayList<Int>()
    val fruitItem = ArrayList<String>()
    val fruitCountInt = ArrayList<Int>()
    val macaronItem = ArrayList<String>()
    val macaronCountInt = ArrayList<Int>()

    // Fragment
    val coffeeView = CoffeeStock()
    val dairyView = DairyStock()
    val dessertView = DessertStock()
    val fruitView = FruitStock()
    val macaronView = MacaronStock()
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Django Web Server에서 데이터를 가져오는 스레드 작업 처리
        storage_data.setOnClickListener {
            thread {
                // Django Web Server IP
                val site = "http://172.30.1.34:8000/coffee"
                val root = getDjangoData(site)
                for (i in 0 until root.length()) {
                    var jsonObj = root.getJSONObject(i)
                    var coffee = jsonObj.getString("bean_name")
                    var count = jsonObj.getInt("bean_count")
                    activity?.runOnUiThread {
                        coffeeItem.add(coffee)
                        coffeeCountInt.add(count)
                        coffeeCounts.add(count.toFloat())
                    }
                }
            }
            thread {
                // Django Web Server IP
                val site = "http://172.30.1.34:8000/dairy"
                val root = getDjangoData(site)
                for (i in 0 until root.length()) {
                    var jsonObj = root.getJSONObject(i)
                    var dairy = jsonObj.getString("dairy_name")
                    var count = jsonObj.getInt("dairy_count")
                    activity?.runOnUiThread {
                        dairyItem.add(dairy)
                        dairyCountInt.add(count)
                        dairyCounts.add(count.toFloat())
                    }
                }
            }
            thread {
                // Django Web Server IP
                val site = "http://172.30.1.34:8000/dessert"
                val root = getDjangoData(site)
                for (i in 0 until root.length()) {
                    var jsonObj = root.getJSONObject(i)
                    var dessert = jsonObj.getString("dessert_name")
                    var count = jsonObj.getInt("dessert_count")
                    activity?.runOnUiThread {
                        dessertItem.add(dessert)
                        dessertCountInt.add(count)
                        dessertCounts.add(count.toFloat())
                    }
                }
            }
            thread {
                val site = "http://172.30.1.34:8000/fruit"
                val root = getDjangoData(site)
                for (i in 0 until root.length()) {
                    var jsonObj = root.getJSONObject(i)
                    var fruit = jsonObj.getString("fruit_name")
                    var count = jsonObj.getInt("fruit_count")
                    activity?.runOnUiThread {
                        fruitItem.add(fruit)
                        fruitCountInt.add(count)
                        fruitCounts.add(count.toFloat())
                    }
                }
            }
            thread {
                // Django Web Server IP
                val site = "http://172.30.1.34:8000/macaron"
                val root = getDjangoData(site)
                for (i in 0 until root.length()) {
                    var jsonObj = root.getJSONObject(i)
                    var macaron = jsonObj.getString("mac_name")
                    var count = jsonObj.getInt("mac_count")
                    activity?.runOnUiThread {
                        macaronItem.add(macaron)
                        macaronCountInt.add(count)
                        macaronCounts.add(count.toFloat())
                    }
                }
            }
        }

        // 그래프 그리는 작업 처리
        coffee_storage.setOnClickListener {
            makeBarEntries(coffeeEntries,coffeeCounts)
            val coffeeBundle = Bundle()
            coffeeBundle.putStringArrayList("coffee", coffeeItem)
            coffeeBundle.putIntegerArrayList("count", coffeeCountInt)
            fragmentTask(coffeeView,coffeeBundle)
        }
        dairy_storage.setOnClickListener {
            makeBarEntries(dairyEntries,dairyCounts)
            val dairyBundle = Bundle()
            dairyBundle.putStringArrayList("dairy", dairyItem)
            dairyBundle.putIntegerArrayList("count", dairyCountInt)
            fragmentTask(dairyView,dairyBundle)
        }
        dessert_storage.setOnClickListener {
            makeBarEntries(dessertEntries,dessertCounts)
            val dessertBundle = Bundle()
            dessertBundle.putStringArrayList("dessert",dessertItem)
            dessertBundle.putIntegerArrayList("count",dessertCountInt)
            fragmentTask(dessertView,dessertBundle)
        }
        fruit_storage.setOnClickListener {
            makeBarEntries(fruitEntries,fruitCounts)
            val fruitBundle = Bundle()
            fruitBundle.putStringArrayList("fruit", fruitItem)
            fruitBundle.putIntegerArrayList("count", fruitCountInt)
            fragmentTask(fruitView, fruitBundle)
        }
        macaron_storage.setOnClickListener {
            makeBarEntries(macaronEntries,macaronCounts)
            val macaronBundle = Bundle()
            macaronBundle.putStringArrayList("macaron", macaronItem)
            macaronBundle.putIntegerArrayList("count", macaronCountInt)
            fragmentTask(macaronView, macaronBundle)
        }

        // 그래프 환경설정
        // if more than 60 entries are displayed in the chart, no values will be drawn
        draw_bar_graph.setMaxVisibleValueCount(60)
        draw_bar_graph.setDrawGridBackground(false)

        // x-Axis Style
        val xax = draw_bar_graph.xAxis
        xax.position = XAxis.XAxisPosition.BOTTOM
        xax.setDrawAxisLine(true)
        xax.setDrawGridLines(false)
        xax.granularity = 10f
        xax.isEnabled = true

        // Set label count to 5 as we are displaying 5 star rating
        xax.labelCount = 15

        // y-Left Axis Style
        val yLax = draw_bar_graph.axisLeft
        yLax.setDrawAxisLine(true)
        yLax.setDrawGridLines(true)
        yLax.axisMinimum = 0f
        yLax.isEnabled = false

        // y-Right Axis Style
        val yRax = draw_bar_graph.axisRight
        yRax.setDrawAxisLine(true)
        yRax.setDrawGridLines(false)
        yRax.axisMinimum = 0f
        yRax.isEnabled = false

        // Legend Style
        val barLegend = draw_bar_graph.legend
        barLegend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        barLegend.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        barLegend.orientation = Legend.LegendOrientation.HORIZONTAL
        barLegend.setDrawInside(false)
        barLegend.formSize = 8f
        barLegend.xEntrySpace = 4f

        draw_bar_graph.setFitBars(true)

        // Set bar entries and add necessary formatting
        //setGraphData()

        // Add animation to the graph
        draw_bar_graph.animateY(2500)
    }
    fun fragmentTask(fragment:Fragment, bundle:Bundle) {
        fragment.arguments = bundle
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.sub_cart_list, fragment).commit()
    }

    fun getDjangoData(site:String): JSONArray {
        val url = URL(site)
        val con = url.openConnection() as HttpURLConnection
        val isr = InputStreamReader(con.inputStream,"UTF-8")
        val br = BufferedReader(isr)

        var str:String? = null

        val buf = StringBuffer()
        do {
            str = br.readLine()
            if (str != null) {
                buf.append(str)
            }
        } while (str != null)
        val data = buf.toString()
        val root = JSONArray(data)

        return root
    }

    fun makeBarEntries(stockEntries:ArrayList<BarEntry>, stockCounts:ArrayList<Float>) {
        // Add a list of bar entries
        for (i in 0 until stockCounts.size) {
            val indexNum = "${i}f"
            stockEntries.add(BarEntry(indexNum.toFloat(), stockCounts[i]))
        }

        // Set the colors for bars with first color for 1*, second for 2* and so on
        // 밑에서 색깔을 지정
        // BarDataSet의 label은 범례에서 나타난다.
        val barDataSet = BarDataSet(stockEntries, "Bar Data Set")
        barDataSet.setColors(
                ContextCompat.getColor(draw_bar_graph.context, R.color.red),
                ContextCompat.getColor(draw_bar_graph.context,R.color.orange),
                ContextCompat.getColor(draw_bar_graph.context, R.color.yellow),
                ContextCompat.getColor(draw_bar_graph.context, R.color.yellow_green),
                ContextCompat.getColor(draw_bar_graph.context, R.color.green),
                ContextCompat.getColor(draw_bar_graph.context, R.color.teal_700),
                ContextCompat.getColor(draw_bar_graph.context, R.color.teal_200),
                ContextCompat.getColor(draw_bar_graph.context, R.color.blue),
                ContextCompat.getColor(draw_bar_graph.context, R.color.purple_200),
                ContextCompat.getColor(draw_bar_graph.context, R.color.purple_500)
        )

        // Set bar shadow
        draw_bar_graph.setDrawBarShadow(true)
        barDataSet.barShadowColor = Color.argb(40,150,150,105)

        val data = BarData(barDataSet)
        // Set the bar width
        data.barWidth = 0.9f

        draw_bar_graph.data = data
        draw_bar_graph.invalidate()
    }
}