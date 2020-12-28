package com.nindikiranaf.poppinsapp.data.model

data class RecipeList (

    val method : String = "",
    val status: Boolean = true,
    val results: List<Recipe> = arrayListOf()

)
