package com.hamza.iti_android

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.hamza.iti_android.databinding.ActivityMainBinding
import com.hamza.iti_android.utils.showToast
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var arrGender = arrayListOf<String>()
    private var arrHobbies = arrayListOf<String>()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        arrHobbies.clear()
        arrGender
        actions()
        showingToast()


    }

    private fun showingToast() {
       // manageInputs()
        manageCheckBox()
        manageRadioButton()

        showToast("Your userName is ${binding.edtUsername.text.toString()} \n ${arrHobbies.joinToString()} " +
                "\n ${arrGender.joinToString()}")


    }

    private fun manageInputs() {
        val text = binding.edtUsername.text

        if (text.equals(null)) {
          //  arr.add("Your username is ${text}\n")
        }
    }


    private fun manageRadioButton() {
        binding.maleCheck.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.femaleCheck.isChecked = false

                arrGender.add("Your gender is ${binding.maleCheck.text.toString()}\n")

            }
        }

        binding.femaleCheck.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.maleCheck.isEnabled = false
                arrGender.add("Your gender is ${binding.maleCheck.text.toString()}\n")


            }
        }

    }

    private fun manageCheckBox() {


        binding.apply {
            sport1.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    arrHobbies.add(binding.sport1.text.toString())

                }

            }
            sport2.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    arrHobbies.add(binding.sport2.text.toString())


                }
                sport3.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        arrHobbies.add(binding.sport2.text.toString())

                    }

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

