package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.MainActivity
import com.polich.kneecap.data.LevelDif.levelSection
import com.polich.kneecap.adapters.MyRecyclerViewAdapter
import com.polich.kneecap.R

class LevelSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as MainActivity).setAppBarTitle("Уровни")
        var yearsPlants_curent = yearsPlants
        val level = arrayListOf(levelSection[0].name, levelSection[1].name, levelSection[2].name)

        val view = inflater.inflate(R.layout.fragment_level_selection, container, false)
        val recycler : RecyclerView = view.findViewById(R.id.recyclerLevel)
        val columns : Int = 1

        recycler.layoutManager = GridLayoutManager(requireContext(), columns)

        val adapter = MyRecyclerViewAdapter(this, level)
        recycler.adapter = adapter

        return view
    }
    companion object{
        var yearsPlants = 4
    }
}