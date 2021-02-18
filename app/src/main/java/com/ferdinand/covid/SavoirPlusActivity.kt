package com.ferdinand.covid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SavoirPlusActivity : AppCompatActivity() {

    lateinit var btn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savoir_plus)

        btn = findViewById(R.id.btnensav)
        btn.setOnClickListener(View.OnClickListener {
            var intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://covid19.gouv.tg"))
            startActivity(intent)
        })
    }
}
