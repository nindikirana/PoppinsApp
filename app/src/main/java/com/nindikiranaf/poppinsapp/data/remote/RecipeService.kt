package com.nindikiranaf.poppinsapp.data.remote


import com.nindikiranaf.poppinsapp.data.model.RecipeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeService {
    @GET("/api/recipes")
    fun listRecipe() : Call<RecipeList>

    @GET("/api/recipe/:key")
    fun detailRecipe(@Query("detail")detail: String) : Call<RecipeList>

    @GET("/api/search/?q=parameter")
    fun searchRecipe(@Query("q")query: String) : Call<RecipeList>
}