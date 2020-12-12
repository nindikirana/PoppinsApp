package com.nindikiranaf.poppinsapp.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nindikiranaf.poppinsapp.R
import com.nindikiranaf.poppinsapp.data.repository.AuthRepository
import com.nindikiranaf.poppinsapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    val parent:AuthActivity by lazy { activity as AuthActivity }
    val viewModel: AuthViewModel by lazy { AuthViewModel(AuthRepository(parent)) }
    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        binding.butonLogin.setOnClickListener {
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment3())
        }
    }

    private fun init() {
        viewModel.authRegister.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("Register","isConsumed")
            }else if(!it.isSuccess){
                Toast.makeText(parent, "Data Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(parent, "Anda Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment3())
            }
            it.isConsumed = true
        }
    }
}