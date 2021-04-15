package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.*
import com.polich.kneecap.adapters.SpinnerRecyclerViewAdapter
import com.polich.kneecap.data.Sevoob

class InstrumentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_instruments, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.spinnerRecyclerView)

        recycler.adapter = SpinnerRecyclerViewAdapter(this, arrayListOf("1"), object:CategorySelectListener {
            override fun onCategorySelected() {
                view?.findNavController()?.navigate(R.id.fragmentInstruments)
                (requireActivity() as MainActivity).setAppBarTitle("Инструменты")
            }
        }, object :InstrumentSelectListener{
            override fun onInstrumentSelected() {
                view.findNavController().navigate(R.id.gameFragment)
            }
        })

        recycler.layoutManager = LinearLayoutManager(this.context)
        return view
    }
}