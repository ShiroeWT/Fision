package com.example.fision

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FeaturedAdapter(
    private val featuredLocations: ArrayList<FeaturedHelperClass>
) : RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.featured_card_design, parent, false)
        return FeaturedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        val featuredHelperClass = featuredLocations[position]
        holder.image.setImageResource(featuredHelperClass.image)
        holder.title.text = featuredHelperClass.title
        holder.description.text = featuredHelperClass.description
    }

    override fun getItemCount(): Int {
        return featuredLocations.size
    }

    class FeaturedViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.featured_image)
        val title: TextView = itemView.findViewById(R.id.featured_title)
        val description: TextView = itemView.findViewById(R.id.featured_desc)
    }

    // Inside your activity's onCreate or fragment's onViewCreated
    private fun featuredRecycler(@NonNull itemView: View) {
        val featuredRecycler: RecyclerView = itemView.findViewById(R.id.featured_recycler) // Correctly initialize the RecyclerView

        // Ensure context is available
        val context = itemView.context

        featuredRecycler.setHasFixedSize(true)
        featuredRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val featuredLocations = ArrayList<FeaturedHelperClass>()

        // Add items
        featuredLocations.add(
            FeaturedHelperClass(
                R.drawable.fision_featuredburger_launcher_background,
                "Burger Special",
                "Delicious burger with fresh ingredients"
            )
        )
        featuredLocations.add(
            FeaturedHelperClass(
                R.drawable.fision_featuredburger_launcher_background,
                "Pizza Delight",
                "Cheesy pizza with a variety of toppings"
            )
        )
        featuredLocations.add(
            FeaturedHelperClass(
                R.drawable.fision_featuredburger_launcher_background,
                "Dessert Heaven",
                "Sweet and delightful desserts to enjoy"
            )
        )

        // Set adapter
        val adapter = FeaturedAdapter(featuredLocations)
        featuredRecycler.adapter = adapter
    }
}
