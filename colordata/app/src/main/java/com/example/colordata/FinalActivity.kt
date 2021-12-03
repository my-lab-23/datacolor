package com.example.colordata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val webViewF = findViewById(R.id.webViewF) as WebView

        val address = "http://192.168.1.196:9000"
        webViewF.loadUrl("${address}/final_combo")
    }
}
