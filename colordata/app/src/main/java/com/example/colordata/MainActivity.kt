package com.example.colordata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import com.example.my_http.MyHTTP
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 1

        fun final() {
            if(count == 9) {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
            } else {
                count += 1
            }
        }

        val webView1 = findViewById(R.id.webView1) as WebView
        val webView2 = findViewById(R.id.webView2) as WebView
        val button1 = findViewById(R.id.button1) as Button
        val button2 = findViewById(R.id.button2) as Button

        val address = "http://192.168.1.196:9000"

        webView1.loadUrl("${address}/uno")
        webView2.loadUrl("${address}/due")

        button1.setOnClickListener {
            lifecycleScope.launch {
                MyHTTP.get("${address}/scelto_uno")
            }
            webView1.loadUrl("${address}/uno")
            webView2.loadUrl("${address}/due")

            final()
        }

        button2.setOnClickListener {
            lifecycleScope.launch {
                MyHTTP.get("${address}/scelto_due")
            }
            webView1.loadUrl("${address}/uno")
            webView2.loadUrl("${address}/due")

            final()
        }
    }
}
