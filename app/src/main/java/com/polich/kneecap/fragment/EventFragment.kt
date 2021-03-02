package com.polich.kneecap.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.polich.kneecap.Event
import com.polich.kneecap.LevelDif
import com.polich.kneecap.NaturalDisasters
import com.polich.kneecap.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EventFragment : Fragment() {
    var curent_level = mutableListOf<Event>()
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var level = requireArguments().getString("level")
        if(level != null){
            when(level){
                "easy" -> curent_level = LevelDif.easyLevelEvent
                "medium" -> curent_level = LevelDif.mediumLevelEvent
                "hard" ->  curent_level = LevelDif.hardLevelEvent
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        Log.e("data",curent_level.toString())
        //val naturalDisasters = NaturalDisasters()
        //val oneEvant = naturalDisasters.naturalEventForLevel[1]

        return view
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EventFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}