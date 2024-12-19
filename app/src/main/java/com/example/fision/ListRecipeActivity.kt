package com.example.fision

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fision.databinding.ActivityMainBinding
import com.example.fision.databinding.ActivityRecipeGeneratorBinding
import com.example.fision.databinding.ActivityListRecipeBinding
import com.example.fision.R.*
import com.example.fision.FeaturedHelperClass

class ListRecipeActivity : AppCompatActivity() {
    @Suppress("Lateinitusage")
    private lateinit var featuredRecyclerAi: RecyclerView
    private lateinit var binding: ActivityListRecipeBinding
    val resulted_resep = SharedData.resultedResep

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        binding = ActivityListRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener { backToMainPage() }


        // Hooks
        featuredRecyclerAi = findViewById(R.id.featured_recycler_ai)

        // Initialize the RecyclerView
        featuredRecyclerAiSetup(featuredRecyclerAi)


    }



    private fun featuredRecyclerAiSetup(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        val featuredLocations = arrayListOf(
//            FeaturedHelperClass(R.drawable.featuredburger, "Burger Special", "Delicious burger with fresh ingredients"),
//            FeaturedHelperClass(R.drawable.pizza, "Pizza Delight", "Cheesy pizza with a variety of toppings"),
//            FeaturedHelperClass(R.drawable.heavenlydessert, "Dessert Heaven", "Sweet and delightful desserts to enjoy"),
//            FeaturedHelperClass(R.drawable.oreoicecream, "Oreo Ice Cream", "Ice cream filling cake, with a lot of oreo")
//        )

        val featuredLocations = resulted_resep.map { recipe ->
            FeaturedHelperClass(
                image = R.drawable.default_image,
                title = recipe.namaResep,
                description = recipe.description
            )
        }.toCollection(ArrayList())


        val adapter = FeaturedAdapter(featuredLocations)
        recyclerView.adapter = adapter
    }

    private fun recipeGenerator() {
        println("masuk recipeGenerator")
        val intent = Intent(this@ListRecipeActivity, RecipeGeneratorActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun backToMainPage() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
//        Log.d("backToMainPage")
        println("backToMainPage")
        finish();
    }

}