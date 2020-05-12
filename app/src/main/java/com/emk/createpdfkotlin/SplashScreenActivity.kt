package com.emk.createpdfkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object: Thread() {
            override fun run() {
                try {
                    sleep(750)
                    val mainActivity = Intent(baseContext, MainActivity::class.java)
                    startActivity(mainActivity)
                }
                catch (e: Exception)
                {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
