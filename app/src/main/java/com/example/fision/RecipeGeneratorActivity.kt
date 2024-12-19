package com.example.fision

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.semantics.text
import com.example.fision.Constants.MODEL_PATH
import com.example.fision.databinding.ActivityRecipeGeneratorBinding
import com.example.fision.Constants.LABELS_PATH
import com.example.fision.entity.Bahan
import com.example.fision.entity.Recipies
import com.example.fision.entity.RecipiesList

class RecipeGeneratorActivity : AppCompatActivity(), Detector.DetectorListener {

    private lateinit var binding: ActivityRecipeGeneratorBinding
    private lateinit var detector: Detector
//    val recipies = arrayListOf<Recipies>();
//    val bahans = arrayListOf<Bahan>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeGeneratorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detector = Detector(baseContext, MODEL_PATH, LABELS_PATH, this)
        detector.setup()

        binding.selectImageButton.setOnClickListener { selectImageFromGallery() }
        binding.captureImageButton.setOnClickListener { captureImageFromCamera() }
        binding.backButtonRecipe.setOnClickListener{ backToMainPage() }

    }

    private fun selectImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(intent)
    }

    private fun captureImageFromCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraLauncher.launch(intent)
    }

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val imageUri: Uri? = result.data?.data
            if (imageUri != null) {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                processImage(bitmap)
            }
        }
    }

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? Bitmap
            if (bitmap != null) {
                processImage(bitmap)
            }
        }
    }

    private fun processImage(bitmap: Bitmap) {
        binding.inputImageView.setImageBitmap(bitmap)
        detector.detect(bitmap)
    }

    override fun onDestroy() {
        super.onDestroy()
        detector.clear()
    }

    override fun onEmptyDetect() {
        binding.overlay.invalidate()
        val intent = Intent(this, ListRecipeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDetect(boundingBoxes: List<BoundingBox>, inferenceTime: Long) {
//        val db = AppDatabase.getInstance(applicationContext)
//        val resepDao = db.resepDao()
        runOnUiThread {
//            binding.inferenceTime.text = "${inferenceTime}ms"

            // Update overlay to display bounding boxes
            binding.overlay.apply {
                setResults(boundingBoxes) // Pass bounding boxes to the overlay
                invalidate() // Redraw the overlay
            }

            // Display results as text (optional)
            val resultsText = boundingBoxes.joinToString("\n") { box ->
                "Label: ${box.clsName})}"

            }

            // Yang di ambil
            val resultFormatted = boundingBoxes.joinToString("\n") { box -> "${box.clsName}"}
            val resultArray = resultFormatted.split("\n").toTypedArray()
            val id_bahan_existim = mutableListOf<Bahan>();
            for(element in resultArray){
                id_bahan_existim.addAll(RecipiesList.bahans.filter { it.namaBahan == element })
            }

            val resulted_resep : ArrayList<Recipies> = arrayListOf()
            for (element in id_bahan_existim) {
                if (element.resepId < RecipiesList.recipies.size && resulted_resep.contains(RecipiesList.recipies[element.resepId.toInt()]).not()) { // Check for index bounds
                    resulted_resep.add(RecipiesList.recipies[element.resepId.toInt()]) // Access with valid index
                }
            }

//            binding.resultsTextView.text = resulted_resep.joinToString(", ") { it.namaResep }
            println(resulted_resep)
            println(id_bahan_existim)
            println(resultFormatted)
//            println(resultFormatted)


            SharedData.resultedResep = resulted_resep
            val intent = Intent(this, ListRecipeActivity::class.java)
            startActivity(intent)
            finish()


        }




    }





    private fun backToMainPage() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
//        Log.d("backToMainPage")
        println("backToMainPage")
        finish();
    }

}

object SharedData{
    var resultedResep = arrayListOf<Recipies>();
}
