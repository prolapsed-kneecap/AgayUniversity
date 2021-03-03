package com.polich.kneecap.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.polich.kneecap.*

class EventFragment : Fragment() {
    var current_level = mutableListOf<Event>()
    //var current_event =  0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var level = requireArguments().getString("level")
        if(level != null){
            when(level){
                "easy" -> current_level = LevelDif.easyLevelEvent
                "medium" -> current_level = LevelDif.mediumLevelEvent
                "hard" ->  current_level = LevelDif.hardLevelEvent
            }
        }
        /*var year = requireArguments().getString("POLE")
        year.let {
            when(year){
                "1" -> current_event = LevelDif.levelSection[0].amountOfEvents
                "2" -> current_event = LevelDif.levelSection[1].amountOfEvents
                "3" -> current_event = LevelDif.levelSection[2].amountOfEvents
            }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event, container, false)
        Log.e("data",current_level.toString())

        val titleEvent : TextView = view.findViewById(R.id.titleEvent)
        val descriptionEvent : TextView = view.findViewById(R.id.descriptionEvent)
        val btnDoneAnswer : MaterialButton = view.findViewById(R.id.done)

        titleEvent.text = current_level[0].eventName
        descriptionEvent.text = current_level[0].description

        btnDoneAnswer.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("level",requireArguments().getString("level"))
            view?.findNavController()?.navigate(R.id.action_eventFragment_to_gameFragment, bundle)
        }

        return view
    }
}