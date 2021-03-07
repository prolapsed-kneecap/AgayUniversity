package com.polich.kneecap.adapters

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.polich.kneecap.data.LevelDif.levelSection
import com.polich.kneecap.R
import com.polich.kneecap.fragment.LevelSelectionFragment.Companion.yearsPlants
import com.polich.kneecap.fragment.completedLevels

class MyRecyclerViewAdapter(var fragment: Fragment, data: ArrayList<String>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.DataViewHolder>() {

    val mData = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.onBing(mData[position],position)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class DataViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var card: MaterialCardView = itemView.findViewById(R.id.item_level)
        var liner : LinearLayout = itemView.findViewById(R.id.backImage)
        var title: TextView = itemView.findViewById(R.id.info_text)
        var cardImage:ImageView = itemView.findViewById(R.id.cardImage)

        fun onBing(data: String, position: Int) {
            title.text = "Уровень ${data}"
            /*var star1 = itemView.findViewById<ImageView>(R.id.one_star)
            var star2 = itemView.findViewById<ImageView>(R.id.two_star)
            var star3 = itemView.findViewById<ImageView>(R.id.three_star)

            star1.setColorFilter(Color.rgb(105, 105, 105))
            star2.setColorFilter(Color.rgb(105, 105, 105))
            star3.setColorFilter(Color.rgb(105, 105, 105))

            title.text = "Уровень ${data}"
            if (position==0){fillstars(star1, star2, star3, scoreHistory[0])}
            if (position==1){fillstars(star1, star2, star3, scoreHistory[1])}
            if (position==2){fillstars(star1, star2, star3, scoreHistory[2])}*/

            if (position in arrayOf(1, 2)) {
                card.isEnabled = false
                cardImage.setBackgroundColor(Color.rgb(181, 181, 181))
            }
            if (completedLevels==1) {
                if (position==1){
                    card.isEnabled = true
                    cardImage.setBackgroundColor(Color.rgb(147, 223, 178))
                }
            }
            if (completedLevels>1){
                if (position==1){
                    card.isEnabled = true
                    cardImage.setBackgroundColor(Color.rgb(147, 223, 178))
                }
                if (position==2){
                    card.isEnabled = true
                    cardImage.setBackgroundColor(Color.rgb(147, 223, 178))
                }
            }
//            if (position in arrayOf(2)){
//                card.isEnabled = false
//                imageCard.setBackgroundColor(Color.rgb(181,181,181))
//                if (completedLevels==2 && position == 2){
//                    card.isEnabled = true
//                    imageCard.setBackgroundColor(Color.rgb(147, 223, 178))
//                }
//            }
            card.setOnClickListener{
                val bundle = Bundle()
                when(data){
                    "1" -> yearsPlants =+ levelSection[0].years
                    "2" -> yearsPlants =+ levelSection[1].years
                    "3" -> yearsPlants =+ levelSection[2].years
                }
                var levelw = ""
                when(position){
                    0 -> levelw = "easy"
                    1 -> levelw = "medium"
                    2 -> levelw = "hard"
                }

                bundle.putString("level",levelw)
                bundle.putString("POLE", data)
                fragment.requireActivity().findNavController(R.id.nav_host_fragment)
                    .navigate(R.id.action_levelSelectionFragment_to_gameFragment, bundle)
            }
        }

    }

    fun getItem(id: Int): String {
        return mData[id]
    }
    fun fillstars(star1:ImageView, star2:ImageView, star3:ImageView, score:Int){
        if (score<=749){
            star1.visibility= VISIBLE
        }
        else
            if (score<1000){
                star1.visibility = VISIBLE
                star2.visibility = VISIBLE
            }
            else
                star1.visibility = VISIBLE
                star2.visibility = VISIBLE
                star3.visibility = VISIBLE
    }
}