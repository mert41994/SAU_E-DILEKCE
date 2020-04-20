package com.emk.createpdfkotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

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
        val arrayAdapter: ArrayAdapter<*>
        val items1 = arrayOf(
            "Lorem", "İpsum", "Dolor",
            "Sit", "Amet","Lorem", "İpsum", "Dolor",
            "Sit", "Amet","Lorem", "İpsum", "Dolor",
            "Sit", "Amet","Lorem", "İpsum", "Dolor",
            "Sit", "Amet","Lorem", "İpsum", "Dolor",
            "Sit", "Amet","Lorem", "İpsum", "Dolor",
            "Sit", "Amet"
        )
        val items2 = arrayOf(
            "item","item","item","item","item",
            "item","item","item","item","item",
            "item","item","item","item","item",
            "item","item","item","item","item",
            "item","item","item","item","item"
        )

        // access the listView from xml file
        var mListView = view.findViewById<ListView>(R.id.history_list)
        arrayAdapter = ArrayAdapter(activity!!.baseContext,
            android.R.layout.simple_list_item_1, items1 + items2)
        mListView.adapter = arrayAdapter

        return view
    }



}
