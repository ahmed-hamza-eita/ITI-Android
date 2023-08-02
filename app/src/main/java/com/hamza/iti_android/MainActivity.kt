package com.hamza.iti_android

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hamza.iti_android.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        actions()
    }

    private fun actions() {
        binding.changeLanguage.setOnClickListener {
            val currentLocale = resources.configuration.locale
            val targetLocale = if (currentLocale.language == "ar") Locale("en") else Locale("ar")
            setLocale(targetLocale)
            recreate()
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

