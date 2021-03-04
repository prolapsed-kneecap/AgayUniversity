package com.polich.kneecap.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.polich.kneecap.R
import com.polich.kneecap.data.TemporaryObject.playerScore

class ResultFragment : Fragment() {

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

        go_to_selectLevel.setOnClickListener {
            view.findNavController().navigate(R.id.action_resultFragment_to_levelSelectionFragment)
        }

        return view
    }
    fun fillStars(star1:ImageView, star2:ImageView, star3:ImageView, resultTextView:TextView){
        if(playerScore<500){resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Вам явно нужно больше практики"}
        if (playerScore>=500){star1.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Стоит потренироваться ещё!"}
        if (playerScore>=750){star2.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Вы молодец, но нужно больше практики."}
        if (playerScore>=1000){star3.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100! \n Идеально!"}
    }
}