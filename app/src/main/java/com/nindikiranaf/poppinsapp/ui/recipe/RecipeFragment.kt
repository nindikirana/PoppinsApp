package com.nindikiranaf.poppinsapp.ui.recipe

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nindikiranaf.poppinsapp.R
import com.nindikiranaf.poppinsapp.databinding.FragmentRecipeBinding
import com.nindikiranaf.poppinsapp.ui.home.MainActivity

class RecipeFragment : Fragment() {
    private val parent: MainActivity by lazy {activity as MainActivity}
    private lateinit var binding: FragmentRecipeBinding
    private val viewModel: RecipeViewModel by lazy {RecipeViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(inflater, container,false).apply {
            viewModel = this@RecipeFragment.viewModel
            lifecycleOwner = this@RecipeFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = RecipeAdapter(parent)
        viewModel.listRecipe()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listRecipe()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
        binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if(it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if(!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}