package com.polich.kneecap.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.polich.kneecap.*
import com.polich.kneecap.adapters.SevoobRecyclerViewAdapter
import com.polich.kneecap.data.Plants.plants
import com.polich.kneecap.data.Sevoob.culturesChosen


class SevoobFragment : Fragment() {
//    var current_level= mutableListOf<Event>()
//    var current_level_left = current_level
//    var current_good_answer = mutableSetOf<MethodsStruggle>()
//    var current_bad_answer = mutableSetOf<MethodsStruggle>()
    val selectedItems = ArrayList<Int>()
    var textsev = "Выберите культуру"
    var sevoob = arrayListOf("1", "2", "3", "4")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sevoob, container, false)

        var recycler : RecyclerView = view.findViewById(R.id.rekukler)
        var moveToGameFragmentButton:Button = view.findViewById(R.id.moveToGameFragmentButton)

        var columns = 1

        moveToGameFragmentButton.text = "$culturesChosen/${sevoob.size}"
        moveToGameFragmentButton.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_eventFragment_to_gameFragment)
        }

        recycler.layoutManager = GridLayoutManager(requireContext(), columns)
        val adapter = SevoobRecyclerViewAdapter(this, sevoob)
        recycler.adapter = adapter
        return view
    }
}













