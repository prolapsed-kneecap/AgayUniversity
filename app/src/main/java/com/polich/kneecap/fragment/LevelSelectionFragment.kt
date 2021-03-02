package com.polich.kneecap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polich.kneecap.Level
import com.polich.kneecap.Leveldif
import com.polich.kneecap.Leveldif.Levelsection
import com.polich.kneecap.adapters.MyRecyclerViewAdapter
import com.polich.kneecap.R
var yearsPlants = 0
class LevelSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var yearsPlants_curent = yearsPlants

        val view = inflater.inflate(R.layout.fragment_level_selection, container, false)
        val nameLevel1 = Levelsection[0].name
        val nameLevel2 = Levelsection[1].name
        val nameLevel3 = Levelsection[2].name
        val level = arrayListOf(nameLevel1,nameLevel2,nameLevel3 )
        val recycler : RecyclerView = view.findViewById(R.id.recyclerLevel)
        val columns : Int = 2

        recycler.layoutManager = GridLayoutManager(requireContext(), columns)

        val adapter = MyRecyclerViewAdapter(this, level)
        recycler.adapter = adapter

        // Тут (может и не тут...) надо в зависимости от выбранного уровня изменить переменную damageMultiplier:Int в обьекте

        return view
    }
}