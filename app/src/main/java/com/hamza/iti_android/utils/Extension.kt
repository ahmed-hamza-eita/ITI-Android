package com.hamza.iti_android.utils

import android.content.Context
import android.widget.Toast
import com.hamza.iti_android.R
import io.github.muddz.styleabletoast.StyleableToast


fun Context.showToast(message: Any, duration: Int = Toast.LENGTH_SHORT) {
    StyleableToast.makeText(this, message.toString(), duration, R.style.toastStyle).show();
}