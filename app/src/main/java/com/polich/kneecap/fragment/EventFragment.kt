package com.polich.kneecap.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.polich.kneecap.*
import com.polich.kneecap.data.Event
import com.polich.kneecap.data.LevelDif
import kotlin.random.Random
import kotlin.random.nextInt

class EventFragment : Fragment() {
    var current_level= mutableListOf<Event>()
    var current_level_left = current_level
    //var current_event =  0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var level = requireArguments().getString("level")
        current_level = levelToCurrentLevel(level)
        current_level_left = current_level
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
        var randIndex=0
        if (current_level_left.size<=1){randIndex = 0}
        else {var randIndex = Random.nextInt(0 until current_level_left.size-1)}

        var current_event = getRandomEvent(randIndex)

        //AnswerMaster(current_event)

        titleEvent.text = current_event.eventName
        descriptionEvent.text = current_event.description

        current_level_left.removeAt(randIndex)

        btnDoneAnswer.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("level",requireArguments().getString("level"))
            view?.findNavController()?.navigate(R.id.action_eventFragment_to_gameFragment, bundle)
        }

        return view
    }
    fun getRandomEvent(randIndex:Int): Event {
        if (current_level_left.size==0){current_level_left=current_level}
        Toast.makeText(requireContext(), current_level.size.toString(), LENGTH_SHORT).show()
        return current_level_left[randIndex]
    }

    fun levelToCurrentLevel(level:String?):MutableList<Event>{
        if(level != null){
            when(level){
                "easy" -> current_level = LevelDif.easyLevelEvent
                "medium" -> current_level = LevelDif.mediumLevelEvent
                "hard" ->  current_level = LevelDif.hardLevelEvent
            }
        }
        return current_level
    }
}