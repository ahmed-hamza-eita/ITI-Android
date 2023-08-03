package com.hamza.iti_android

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.hamza.iti_android.databinding.ActivityMainBinding
import com.hamza.iti_android.utils.showToast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var arr = arrayListOf<String>()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()
        showingToast()


    }

    private fun showingToast() {
        manageCheckBox()
        manageRadioButton()
        for (item in arr){
            showToast(item)
        }
    }

    private fun manageRadioButton() {
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val nameOfCheckId = findViewById<RadioButton>(checkedId)
            val name = nameOfCheckId.text.toString()
            arr.add(name)

        }
    }

    private fun manageCheckBox() {
           var msgChcekBox: String? = null
        binding.apply {
            sport1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    arr.add(binding.sport1.text.toString())
                }

            }
            sport2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    arr.add(binding.sport2.text.toString())
                }

            }
            sport3.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    arr.add(binding.sport2.text.toString())
                }

            }
        }
    }


    private fun actions() {
        binding.apply {
            changeLanguage.setOnClickListener {
                val currentLocale = resources.configuration.locale
                val targetLocale =
                    if (currentLocale.language == "ar") Locale("en") else Locale("ar")
                setLocale(targetLocale)
                recreate()
            }
            btnLogin.setOnClickListener {
                showingToast()
            }
        }


    }

    private fun setLocale(locale: Locale) {
        Locale.setDefault(locale)
        val resources: Resources = resources
        val config: Configuration = Configuration(resources.configuration)
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

