package com.polich.kneecap.fragment

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.polich.kneecap.R
import com.polich.kneecap.TemporaryObject.playerScore
import org.w3c.dom.Text

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val star1:ImageView = view.findViewById(R.id.star1)
        val star2:ImageView = view.findViewById(R.id.star2)
        val star3:ImageView = view.findViewById(R.id.star3)
        val resultTextView:TextView =view.findViewById(R.id.resultTextView)

        star1.setColorFilter(Color.argb(255, 105, 105, 105))
        star2.setColorFilter(Color.argb(255, 105, 105, 105))
        star3.setColorFilter(Color.argb(255, 105, 105, 105))

        fillStars(star1, star2, star3, resultTextView)
        return view
    }
    fun fillStars(star1:ImageView, star2:ImageView, star3:ImageView, resultTextView:TextView){
        if (playerScore>=500){star1.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100. Стоит потренироваться ещё!"}
        if (playerScore>=750){star2.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100. Вы молодец, но нужно больше практики."}
        if (playerScore>=1000){star3.setColorFilter(null); resultTextView.text = "Вы набрали "+(playerScore/10).toString()+" баллов из 100. Идеально!"}
    }
}