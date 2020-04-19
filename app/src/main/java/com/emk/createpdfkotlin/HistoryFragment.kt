package com.emk.createpdfkotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Setting this fragment to layout
        val view: View = inflater.inflate(R.layout.fragment_history, container, false)

        TODO("ADD ITEM LIST")


        return view
    }


}
