package com.example.fision

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fision.entity.Bahan
import com.example.fision.entity.Recipies
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var textBoxFision: View // Assuming you have a View named yourView
    private lateinit var textBoxDescription: View // Assuming you have a View named anotherView
    private lateinit var textBoxCopyright: View // Assuming you have a View named thirdView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
            finish() // Finish MainActivity to prevent going back
        }, 5000)

        val imageView = findViewById<ImageView>(R.id.fisionLogoRBG)
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        // Get references to your views
        textBoxFision = findViewById(R.id.textFision) // Replace with yourView's ID
        textBoxDescription = findViewById(R.id.textFisionDesc) // Replace with anotherView's ID
        textBoxCopyright = findViewById(R.id.textFisionCopyright) // Replace with thirdView's ID

        // Apply animations
        textBoxFision.startAnimation(bottomAnimation)
        textBoxDescription.startAnimation(bottomAnimation)
        textBoxCopyright.startAnimation(bottomAnimation)

        imageView.startAnimation(topAnimation)

        // Initialize the database
//        val db = AppDatabase.getInstance(applicationContext)
//        val resepDao = db.resepDao()

    }
}