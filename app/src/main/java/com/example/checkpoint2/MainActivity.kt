package com.example.checkpoint2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbarMain:Toolbar =findViewById(R.id.toolbar_main)
        configureToolbar(toolbarMain)

        val btnRefreshButton: Button = findViewById(R.id.btn_refresh)
        btnRefreshButton.setOnClickListener {
            makeCallRequest()
        }
    }

    private fun makeCallRequest(){
        CoroutineScope(Dispatchers.Main).launch{

        }
    }

    private fun configureToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(getColor(R.color.white))
        supportActionBar?.setTitle(getText(R.string.app_title))
        supportActionBar?.setBackgroundDrawable(getDrawable(R.color.primary))
    }

}

