package com.hamza.iti_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hamza.iti_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        init()

    }

    private fun init() {

        binding.btnOk.setOnClickListener {
            if (binding.edtText.text.toString().isNotEmpty()) {

                binding.txtName.text = "Your Name is " + binding.edtText.text.toString()

            } else {
                binding.edtText.error = "Required"

            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

