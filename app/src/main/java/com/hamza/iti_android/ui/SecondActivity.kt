package com.hamza.iti_android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hamza.iti_android.databinding.ActivitySecondBinding
import com.hamza.iti_android.utils.Const

class SecondActivity : AppCompatActivity() {
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        intent()

    }

    private fun intent() {
        binding.btnLogIn.setOnClickListener {
            val loginInBy =if (binding.loginByGoogle.isChecked){
                "Login by Google"
            }else if (binding.loginByFacebook.isChecked){
               "Login by Facebook"
            } else {
                "ERROR"
            }
            val intent=Intent()
            intent.putExtra(Const.LOGINBY_KEY,loginInBy)
            setResult(Const.RESULTCODE_KEY,intent)
            finish()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}