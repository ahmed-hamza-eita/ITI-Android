package com.hamza.iti_android.ui

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.hamza.iti_android.R
import com.hamza.iti_android.databinding.ActivityMainBinding
import com.hamza.iti_android.utils.Const
import com.hamza.iti_android.utils.CustomDialog
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.goto_secondActivity -> intent()
            R.id.action_exit -> manageDialog()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun manageDialog() {
        val customDialog = CustomDialog()
        customDialog.show(supportFragmentManager, Const.CUSTOM_DIALOG_KEY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Const.REQUESTCODE_KEY) {
            showToast(data?.extras?.getString(Const.LOGINBY_KEY) ?: "ERROR")

        }


    }

    private fun intent() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(Const.USERNAME_KEY, binding.edtUsername.text.toString())
        startActivityForResult(intent, Const.REQUESTCODE_KEY)
    }


    private fun showingToast() {
        manageCheckBox()
        manageRadioButton()


    }


    private fun manageRadioButton() {
        binding.maleCheck.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.femaleCheck.isChecked = false

                arrGender.add(binding.maleCheck.text.toString())

            }
        }

        binding.femaleCheck.setOnCheckedChangeListener { _, b ->
            if (b) {
                binding.maleCheck.isEnabled = false
                arrGender.add(binding.maleCheck.text.toString())


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

            btnNext.setOnClickListener {

                showingToast()
                showToast(
                    "Your userName is ${binding.edtUsername.text.toString()} \n Your Hobbies is ${arrHobbies.joinToString()} " +
                            "\n Your Gender is ${arrGender.joinToString()}"
                )
                intent()
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

