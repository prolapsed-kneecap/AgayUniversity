package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.CategorySelectListener
import com.polich.kneecap.InstrumentSelectListener
import com.polich.kneecap.R
import com.polich.kneecap.adapters.SpinnerRecyclerViewAdapter

class CategoriesFragment:Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_categories, container)
        val recycler = view.findViewById<RecyclerView>(R.id.spinnerRecyclerView)
        recycler.adapter = SpinnerRecyclerViewAdapter(this, arrayListOf("1","2","3","4","5","6","7"), object:
            CategorySelectListener {
            override fun onCategorySelected() {
                view?.findNavController()?.navigate(R.id.action_fragmentCategories_to_fragmentInstruments)
            }
        }, object : InstrumentSelectListener {
            override fun onInstrumentSelected() {
                view.findNavController()?.navigate(R.id.gameFragment)
            }
        })
        recycler.layoutManager = LinearLayoutManager(this.context)
        return view
    }
}