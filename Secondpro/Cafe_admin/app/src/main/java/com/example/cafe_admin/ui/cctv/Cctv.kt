package com.example.cafe_admin.ui.cctv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafe_admin.R
import kotlinx.android.synthetic.main.cctv.*
import java.text.SimpleDateFormat
import java.util.*


class Cctv : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.cctv, container, false)

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val current = Calendar.getInstance().time
        var Format = SimpleDateFormat("yyyy.MM.dd  ", Locale.KOREA).format(current)

        date_text.text = Format
        cctv_view.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
        cctv_view.loadUrl("http://192.168.0.214:5000/show")
    }

}