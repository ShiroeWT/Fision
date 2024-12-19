package com.example.fision

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fision.databinding.ActivityMainBinding
import com.example.fision.databinding.ActivityRecipeGeneratorBinding
import com.example.fision.databinding.DashboardActivityBinding
import com.example.fision.R



class DashboardActivity : AppCompatActivity() {
    @Suppress("Lateinitusage")
    private lateinit var featuredRecycler: RecyclerView
    private lateinit var binding: DashboardActivityBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        binding = DashboardActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Hooks
        featuredRecycler = findViewById(R.id.featured_recycler)
//        featuredRecycler = binding.featuredRecycler
        // Initialize the RecyclerView
        featuredRecyclerSetup(featuredRecycler)
        binding.tryAiButton.setOnClickListener {recipeGenerator()}
    }

    private fun featuredRecyclerSetup(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val featuredLocations = arrayListOf(
            FeaturedHelperClass(R.drawable.featuredburger, "Burger Special", "Delicious burger with fresh ingredients"),
            FeaturedHelperClass(R.drawable.pizza, "Pizza Delight", "Cheesy pizza with a variety of toppings"),
            FeaturedHelperClass(R.drawable.heavenlydessert, "Dessert Heaven", "Sweet and delightful desserts to enjoy"),
            FeaturedHelperClass(R.drawable.oreoicecream, "Oreo Ice Cream", "Ice cream filling cake, with a lot of oreo")
        )

        val adapter = FeaturedAdapter(featuredLocations)
        recyclerView.adapter = adapter
    }

    private fun recipeGenerator() {
        println("masuk recipeGenerator")
        val intent = Intent(this@DashboardActivity, RecipeGeneratorActivity::class.java)
        startActivity(intent)
        finish()
    }
}
