package com.hamza.iti_android.utils
import android.app.Dialog
 import android.os.Bundle
import androidx.appcompat.app.AlertDialog
 import androidx.fragment.app.DialogFragment
import com.hamza.iti_android.databinding.CustomDialogBinding


class   CustomDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = CustomDialogBinding.inflate(inflater)
        builder.setView(dialogView.root)

        dialogView.btnExit.setOnClickListener {

            requireActivity().finish()
        }

        dialogView.btnCancel.setOnClickListener {

            dismiss()
        }

        return builder.create()
    }
}
