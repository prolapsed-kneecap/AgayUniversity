package com.polich.kneecap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.R
import com.polich.kneecap.adapters.SpinnerRecyclerViewAdapter

class InstrumentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instruments, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.spinnerRecyclerView)
        recycler.adapter = SpinnerRecyclerViewAdapter(this, arrayListOf("1","2","3","4","5","6","7"))
        recycler.layoutManager = LinearLayoutManager(this.context)
        return view
    }
}