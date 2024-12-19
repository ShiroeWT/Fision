package com.example.fision.entity

import com.example.fision.entity.Bahan
import com.example.fision.entity.Recipies


object RecipiesList {

    val resepList = listOf(
        Recipies(
            id = 0,
            namaResep = "Nasi Goreng",
            description = "Nasi goreng dengan telur dan kecap",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 1,
            namaResep = "Mie Goreng",
            description = "Mie goreng dengan sayuran dan ayam",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 2,
            namaResep = "Omelet",
            description = "Omelet enak setengah matang",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 3,
            namaResep = "Telor Ceplok",
            description = "Rendang daging sapi khas Padang",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 4,
            namaResep = "Ayam Bakar",
            description = "Ayam bakar dengan bumbu kecap manis",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 5,
            namaResep = "Sup Ayam",
            description = "Sup ayam dengan sayuran segar",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 6,
            namaResep = "Mie kuah",
            description = "Mie dengan kuah hangat yang nikmat",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 7,
            namaResep = "tumis tahu",
            description = "Bakso dengan kuah gurih dan mie",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 8,
            namaResep = "Beef Stew",
            description="masakan daging asam manis gaya barat",
            imagePath = "R.drawable.default_image",
            steps = ""
        ),
        Recipies(
            id = 9,
            namaResep = "fish fillet",
            description="ikan goreng tepung",
            imagePath = "R.drawable.default_image",
            steps= ""
        ),
        Recipies(
            id = 10,
            namaResep = "Ikan kuah kecap",
            description="ikan kuah yang sederhana",
            imagePath = "R.drawable.default_image",
            steps= ""
        ),
        Recipies(
            id = 11,
            namaResep = "Honey Glaze pork",
            description="Babi panggang dengan saos madu",
            imagePath = "R.drawable.default_image",
            steps= ""
        ),
        Recipies(
            id = 12,
            namaResep = "Ayam Goreng Chicken",
            description="Ayam Goreng Crispy, yang enak dimakan dengan nasi",
            imagePath = "R.drawable.default_image",
            steps= ""
        )

    )

    val bahanList = listOf(
        // Bahan untuk Nasi Goreng (resepId = 1)
        Bahan(id = 1, resepId = 0, namaBahan = "rice", jumlahBahan = "1"),
        Bahan(id = 2, resepId = 0, namaBahan = "egg", jumlahBahan = "1"),
        Bahan(id = 3, resepId = 0, namaBahan = "Kecap", jumlahBahan = "1"),

        // Bahan untuk Mie Goreng (resepId = 2)
        Bahan(id = 4, resepId = 1, namaBahan = "noodle", jumlahBahan = "1"),
        Bahan(id = 5, resepId = 1, namaBahan = "indomie", jumlahBahan = "1"),
        Bahan(id = 6, resepId = 1, namaBahan = "chicken", jumlahBahan = "1"),


        // Bahan untuk Omelet (resepId = 3)
        Bahan(id = 7, resepId = 2, namaBahan = "egg", jumlahBahan = "1"),
        Bahan(id = 8, resepId = 2, namaBahan = "garlic", jumlahBahan = "1"),
        Bahan(id = 9, resepId = 2, namaBahan = "onion", jumlahBahan = "1"),
        Bahan(id = 10, resepId = 2, namaBahan = "tomato", jumlahBahan = "1"),

        // Bahan untuk Telor Ceplok (resepId = 4)
        Bahan(id = 11, resepId = 3, namaBahan = "egg", jumlahBahan = "1"),
        Bahan(id = 12, resepId = 3, namaBahan = "garlic", jumlahBahan = "1"),
        Bahan(id = 13, resepId = 3, namaBahan = "onion", jumlahBahan = "1"),

        // Bahan untuk Ayam Bakar (resepId = 5)
        Bahan(id = 14, resepId = 4, namaBahan = "chicken", jumlahBahan = "1"),
        Bahan(id = 15, resepId = 4, namaBahan = "soy sauce", jumlahBahan = "1"),

        // Bahan untuk Sup Ayam (resepId = 6)
        Bahan(id = 16, resepId = 5, namaBahan = "chicken", jumlahBahan = "1"),
        Bahan(id = 17, resepId = 5, namaBahan = "carrot", jumlahBahan = "1"),
        Bahan(id = 18, resepId = 5, namaBahan = "potato", jumlahBahan = "1"),

        // Bahan untuk Mie kuah (resepId = 7)
        Bahan(id = 19, resepId = 6, namaBahan = "noodle", jumlahBahan = "1"),
        Bahan(id = 20, resepId = 6, namaBahan = "indomie", jumlahBahan = "1"),
        Bahan(id = 21, resepId = 6, namaBahan = "garlic", jumlahBahan = "1"),
        Bahan(id = 22, resepId = 6, namaBahan = "onion", jumlahBahan = "1"),

        // Bahan untuk tumis tahu (resepId = 8)
        Bahan(id = 23, resepId = 7, namaBahan = "tofu", jumlahBahan = "1"),
        Bahan(id = 24, resepId = 7, namaBahan = "soy sauce", jumlahBahan = "1"),
        Bahan(id = 25, resepId = 7, namaBahan = "onion", jumlahBahan = "1"),
        Bahan(id = 27, resepId = 7, namaBahan = "garlic", jumlahBahan = "1"),

        // Bahan untuk beef stew (resepId = 9)
        Bahan(id = 28, resepId = 8, namaBahan = "beef", jumlahBahan = "1"),
        Bahan(id = 29, resepId = 8, namaBahan = "soy sauce", jumlahBahan = "1"),

        // Bahan untuk fish fillet (resepId = 10)
        Bahan(id = 30, resepId = 9, namaBahan = "fish", jumlahBahan = "1"),

        // Bahan untuk ikan kuah kecap (resepId = 11)
        Bahan(id = 31, resepId = 10, namaBahan = "fish", jumlahBahan = "1"),
        Bahan(id = 32, resepId = 10, namaBahan = "soy sauce", jumlahBahan = "1"),

        // Bahan untuk Honey Glaze Pork (resepId = 12)
        Bahan(id = 33, resepId = 11, namaBahan = "pork", jumlahBahan = "1"),
        Bahan(id = 34, resepId = 11, namaBahan = "honey", jumlahBahan = "1"),

        // Bahan untuk Ayam Goreng tepung (resepId = 13)
        Bahan(id = 33, resepId = 11, namaBahan = "chicken", jumlahBahan = "1")
    )


    // Menambahkan Elemen ke Daftar
    val recipies = arrayListOf<Recipies>().apply { addAll(resepList) }
    val bahans = arrayListOf<Bahan>().apply { addAll(bahanList) }

}
