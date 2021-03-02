package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.LevelDif.LevelSection
import com.polich.kneecap.adapters.MyRecyclerViewAdapter
import com.polich.kneecap.R

class LevelSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var yearsPlants_curent = yearsPlants
        val level = arrayListOf(LevelSection[0].name, LevelSection[1].name, LevelSection[2].name)

        val view = inflater.inflate(R.layout.fragment_level_selection, container, false)
        val recycler : RecyclerView = view.findViewById(R.id.recyclerLevel)
        val columns : Int = 1

        recycler.layoutManager = GridLayoutManager(requireContext(), columns)

        val adapter = MyRecyclerViewAdapter(this, level)
        recycler.adapter = adapter

        // Тут (может и не тут...) надо в зависимости от выбранного уровня изменить переменную damageMultiplier:Int в обьекте

        return view
    }
    companion object{
        var yearsPlants = 4
    }
}