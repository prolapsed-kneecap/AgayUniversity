package com.polich.kneecap.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.polich.kneecap.R
import com.polich.kneecap.data.FilterObject.blineResult
import com.polich.kneecap.data.FilterObject.glineResult
import com.polich.kneecap.data.FilterObject.rlineResult
import com.polich.kneecap.data.PlayerResults.scoreHistory
import com.polich.kneecap.data.TemporaryObject.playerScore
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var completedLevels = 0

class ResultFragment : Fragment() {

    override fun onDestroy() {
        super.onDestroy()
        val level = requireArguments().getString("levelNow")
        if (level=="1"){
            if (scoreHistory[0]<playerScore){
                scoreHistory[0]= playerScore
            }
        }
        if (level=="2"){
            if (scoreHistory[1]<playerScore){
                scoreHistory[1]= playerScore
            }
        }
        if (level=="3"){
            if (scoreHistory[2]<playerScore){
                scoreHistory[2]= playerScore
            }
        }
        completedLevels++
        playerScore = 0
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val star1: ImageView = view.findViewById(R.id.star1)
        val star2: ImageView = view.findViewById(R.id.star2)
        val star3: ImageView = view.findViewById(R.id.star3)
        val resultTextView: TextView =view.findViewById(R.id.resultTextView)
        val go_to_selectLevel : MaterialButton = view.findViewById(R.id.go_to_select)

        star1.setColorFilter(Color.argb(255, 105, 105, 105))
        star2.setColorFilter(Color.argb(255, 105, 105, 105))
        star3.setColorFilter(Color.argb(255, 105, 105, 105))

        fillStars(star1, star2, star3, resultTextView)

        val level = requireArguments().getString("levelNow")

        go_to_selectLevel.setOnClickListener {
            Toast.makeText(requireContext(), "$level", LENGTH_SHORT).show()
            if (level=="1"){
                if (scoreHistory[0]<playerScore){
                    scoreHistory[0]= playerScore
                }
            }
            if (level=="2"){
                if (scoreHistory[1]<playerScore){
                    scoreHistory[1]= playerScore
                }
            }
            if (level=="3"){
                if (scoreHistory[2]<playerScore){
                    scoreHistory[2]= playerScore
                }
            }
            completedLevels++
            playerScore = 0
            view.findNavController().navigate(R.id.action_resultFragment_to_levelSelectionFragment)
        }

        return view
    }

    fun fillStars(star1: ImageView, star2: ImageView, star3: ImageView, resultTextView: TextView){
        if(playerScore<300){resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Вам явно нужно больше практики"}
        if (playerScore>=300){star1.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Стоит потренироваться ещё!"/*; FilterStart(star1)*/}
        if (playerScore>=500){star2.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Вы молодец, но нужно больше практики."/*; FilterStart(star2)*/}
        if (playerScore>=900){star3.setColorFilter(null); resultTextView.text = "Вы набрали "+(1000/10).toString()+" баллов из 100! \n Идеально!"/*; FilterStart(star3)*/}
    }
    fun FilterStart(star:ImageView){
        MainScope().launch {
            for (i in 1..21){
                lvlupResult()
                star.setColorFilter(Color.argb(0, rlineResult, glineResult, blineResult))
                delay(90)
            }
        }
        star.setColorFilter(Color.argb(0, rlineResult, glineResult, blineResult))
        star.invalidate()
    }
    fun lvlupResult(){
        rlineResult+=7
        glineResult+=7
        blineResult-=5
    }
}