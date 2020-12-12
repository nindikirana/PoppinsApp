package com.nindikiranaf.poppinsapp.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nindikiranaf.poppinsapp.R
import com.nindikiranaf.poppinsapp.databinding.ActivityMainBinding
import com.nindikiranaf.poppinsapp.ui.auth.AuthActivity
import com.nindikiranaf.poppinsapp.ui.auth.PoppinsAppAuth

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonLogout.setOnClickListener {
            PoppinsAppAuth.logout(this){
                startActivity(Intent(this,AuthActivity::class.java))
                finish()
            }
        }
    }
}