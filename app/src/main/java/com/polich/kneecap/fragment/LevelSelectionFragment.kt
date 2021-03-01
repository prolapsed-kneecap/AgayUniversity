package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.Bugs
import com.polich.kneecap.ClimateDisasters
import com.polich.kneecap.NaturalDisasters
import com.polich.kneecap.adapters.MyRecyclerViewAdapter
import com.polich.kneecap.R

class LevelSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_level_selection, container, false)

        val level = arrayListOf("1", "2", "3", "4")
        val recycler : RecyclerView = view.findViewById(R.id.recyclerLevel)
        val columns : Int = 2

        recycler.layoutManager = GridLayoutManager(requireContext(), columns)

        val adapter = MyRecyclerViewAdapter(this, level)
        recycler.adapter = adapter

        // Тут (может и не тут...) надо в зависимости от выбранного уровня изменить переменную damageMultiplier:Int в обьекте

        return view
    }
}