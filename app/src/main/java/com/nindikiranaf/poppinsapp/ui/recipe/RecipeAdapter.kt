package com.nindikiranaf.poppinsapp.ui.recipe

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.nindikiranaf.poppinsapp.R
import com.nindikiranaf.poppinsapp.data.model.Recipe
import com.nindikiranaf.poppinsapp.databinding.ItemRecipeBinding
import com.nindikiranaf.poppinsapp.ui.base.BaseAdapter

class RecipeAdapter(val context: Context) : BaseAdapter<Recipe>(R.layout.item_recipe) {
    override fun onBind(binding: ViewDataBinding?, data: Recipe) {
        val mBinding = binding as ItemRecipeBinding
        Glide.with(context).load(data.thumb).into(mBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Recipe) {
        val intent = Intent(context, RecipeActivity::class.java)
        intent.putExtra(RecipeActivity.OPEN_RECIPE, data)
        context.startActivity(intent)
    }
}