package com.nindikiranaf.poppinsapp.ui.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nindikiranaf.poppinsapp.R

class RecipeActivity : AppCompatActivity() {

    companion object {
        const val OPEN_RECIPE = "open_recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
    }

}