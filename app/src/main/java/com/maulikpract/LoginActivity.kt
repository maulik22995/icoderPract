package com.maulikpract

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.maulikpract.view.pract2.screen1.Practical2Screen1Activity
import com.maulikpract.view.restaurant.RestuarentActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pract1.setOnClickListener {
            startActivity(Intent(this,RestuarentActivity::class.java))
        }

        pract2.setOnClickListener {
            startActivity(Intent(this,Practical2Screen1Activity::class.java))
        }

    }
}