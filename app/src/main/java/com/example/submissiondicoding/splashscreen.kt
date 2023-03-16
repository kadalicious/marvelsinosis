package com.example.submissiondicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

@Suppress("DEPRECATION")
class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Toast.makeText(applicationContext, "Loading",Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)


    }
}