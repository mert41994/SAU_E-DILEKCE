package com.emk.createpdfkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.layout_buttonthree_dialog.*


class ButtonThreeDialogFragment(private val callbackListener: CallbackListener?): DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.layout_buttonthree_dialog, container, false)
        isCancelable = false
        return view
    }

    //Setting Theme on DialogFragment
    override fun getTheme(): Int {
        return R.style.DialogTheme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            //send back data to PARENT fragment using callback
            callbackListener?.onDataReceived(editText.text.toString())
            // Now dismiss the fragment
            dismiss()
        }

    }

}