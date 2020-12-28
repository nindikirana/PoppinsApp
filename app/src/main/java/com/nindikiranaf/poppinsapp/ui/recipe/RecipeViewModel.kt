package com.nindikiranaf.poppinsapp.ui.recipe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nindikiranaf.poppinsapp.data.model.ActionState
import com.nindikiranaf.poppinsapp.data.model.Recipe
import com.nindikiranaf.poppinsapp.data.repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {
    private val repo: RecipeRepository by lazy { RecipeRepository()}

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Recipe>>()
    val detailResp = MutableLiveData<Recipe>()
    val searchResp = MutableLiveData<List<Recipe>>()

    val detail = MutableLiveData("")
    val query = MutableLiveData("")

    fun listRecipe(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listRecipe()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailRecipe(detail: String? = this.detail.value){
        detail?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailRecipe(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchRecipe(query: String? = this.query.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchRecipe(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}