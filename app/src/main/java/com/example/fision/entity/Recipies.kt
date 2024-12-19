package com.example.fision.entity
import com.example.fision.entity.Bahan

public class Recipies (
    val id : Int,
    val namaResep : String,
    val steps: String,
    val imagePath: String,
    val description: String
)

//public class Recipies {
//    val id : Int
//    val namaResep : String
//    val steps: String
//    val bahans: ArrayList<Bahan> = ArrayList()
//
//    constructor(id: Int, namaResep: String, steps: String) {
//        this.id = id
//        this.namaResep = namaResep
//        this.steps = steps
//    }
//
//    fun addBahan(bahan: Bahan) {
//        bahans.add(bahan)
//    }
//}
//
//class RecipeList{
//    val recipies: ArrayList<Recipies> = ArrayList()
//    fun addRecipies(recipies: Recipies) {
//        this.recipies.add(recipies)
//    }
//    fun getRecipies(): ArrayList<Recipies> {
//        return recipies
//    }
//    fun getRecipiesById(id: Int): Recipies? {
//        return recipies.find { it.id == id }
//    }
//    fun getRecipiesByName(name: String): Recipies? {
//        return recipies.find { it.namaResep == name }
//    }
//
//    fun getRecipiesByBahan(bahan: Bahan): Recipies? {
//        return recipies.find { it.bahans.contains(bahan) }
//    }
//}


