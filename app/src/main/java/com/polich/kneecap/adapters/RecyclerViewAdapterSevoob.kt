package com.polich.kneecap.adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.polich.kneecap.CultureSelectListener
import com.polich.kneecap.R
import com.polich.kneecap.data.Plants
import com.polich.kneecap.data.Sevoob.addButtonClicked
import com.polich.kneecap.data.Sevoob.culturesChosen
import com.polich.kneecap.fragment.WebFragment

class SevoobRecyclerViewAdapter(var fragment:Fragment, private val values: List<String>, private val cultureSelectListener: CultureSelectListener) :
    RecyclerView.Adapter<SevoobRecyclerViewAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.sevoob_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBing(position)
        holder.cultureNumberTextView.text = (position+1).toString()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var selectedCulture:TextView = itemView.findViewById(R.id.textView_selected_sevoob)
        var cultureNumberTextView:TextView = itemView.findViewById(R.id.cultureNumberTextView)
        var addButton: Button = itemView.findViewById(R.id.addToSevoob)
        var helpButton:ImageView = itemView.findViewById(R.id.helpImageView)
        var currentButton = -1
        val selectedItems = ArrayList<Int>()
        var buttonsClickedMutableList = fillButtonsClickedMutableList()

        @SuppressLint("RestrictedApi")
        fun onBing(position: Int){
            addButton.setOnClickListener{
                if (!buttonsClickedMutableList[position]){
                    var checkedItem = 1
                    var builder = AlertDialog.Builder(fragment.requireContext())
                    builder.setTitle("Выберите культуру")
                        .setSingleChoiceItems(Plants.plants, checkedItem) { dialog, item ->
                            checkedItem = item
                        }
                        .setPositiveButton("OK"
                        ) { dialog, which ->
                            buttonsClickedMutableList[position] = true
                            addButton.text = "-"
                            helpButton.visibility = VISIBLE
                            selectedCulture.text = Plants.plants[checkedItem]
                            culturesChosen++
                            cultureSelectListener.onCultureSelected()
                        }
                        .setNegativeButton("Отмена") {
                                dialog, id ->
                        }
                    val dialog = builder.create()
                    dialog.show()
                    var Culture_info_list = arrayListOf<String>(
                        itemView.resources.getString(R.string.url_rozh),
                        itemView.resources.getString(R.string.url_oves),
                        itemView.resources.getString(R.string.url_Psheno),
                        itemView.resources.getString(R.string.url_grech),
                        itemView.resources.getString(R.string.url_proso),
                        itemView.resources.getString(R.string.url_podsolnc),
                        itemView.resources.getString(R.string.url_gorox),
                        itemView.resources.getString(R.string.url_kartof),
                        itemView.resources.getString(R.string.url_kykuru),
                        itemView.resources.getString(R.string.url_iach),
                    )


                    currentButton = position

                    helpButton.setOnClickListener {
                        var webFragment = WebFragment()
                        var webView:WebView = WebView(fragment.requireContext())
                        webView.loadUrl(
                            Culture_info_list[checkedItem]
                        )
                        /*val bundle = Bundle()
                        bundle.putString("key", "URL_PLANTED")
                        bundle.putString("URL_PLANTED", itemView.resources.getString(R.string.url_culture))
                        itemView.findNavController().navigate(R.id.action_eventFragment_to_webFragment, bundle)*/
                        var builder = AlertDialog.Builder(fragment.requireContext())
                        builder.setTitle("")
                            .setView(webView)
                            .setNeutralButton("OK"){
                                    dialog, which ->
                            }
                            .show()
                    }
                }
                else {
                    culturesChosen-=1
                    cultureSelectListener.onCultureSelected()
                    buttonsClickedMutableList[position] = false
                    helpButton.visibility = INVISIBLE
                    addButton.text = "+"
                    selectedCulture.text = "Выберите растение"
                }
            }

        }
    }
    fun fillButtonsClickedMutableList():MutableList<Boolean>{
        var buttonsClickedMutableList:MutableList<Boolean> = mutableListOf()
        for (i in values){
            buttonsClickedMutableList.add(false)
        }
        return buttonsClickedMutableList
    }
    /*fun NextField(){

    }*/
}