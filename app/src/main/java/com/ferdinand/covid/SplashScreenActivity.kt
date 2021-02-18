package com.ferdinand.covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.RelativeLayout

class SplashScreenActivity : AppCompatActivity() {

    lateinit var layout:RelativeLayout
    lateinit var hand:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        layout = findViewById(R.id.relativ)

        hand = Handler()

        hand.postDelayed(Runnable {
            var inte = Intent(this,MainActivity::class.java)
            startActivity(inte)
            finish()

        },5000)
    }
}
