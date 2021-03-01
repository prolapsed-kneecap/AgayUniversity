package com.polich.kneecap.fragment

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.polich.kneecap.*
import com.polich.kneecap.Plants.cultures
import com.polich.kneecap.Eventik.instrumentsString
import com.polich.kneecap.adapters.ExpandableListAdapter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameFragment : Fragment() {
    var progress : Int = 0

    val PLANS_COUNT_FOR_FINISH = 4
    val plantMaster = PlantMaster()
    val instrumentMaster = InstrumentMaster()
    val naturalDisasters = NaturalDisasters(/*конструктор блин*/)
    val massivchik = naturalDisasters.naturalEventForLevel

    internal var titleList: List<String> ?= null
    internal var adapter: ExpandableListAdapter?= null


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        val progressBar : ProgressBar = view.findViewById(R.id.progress_bar)
        val expandedListView: ExpandableListView = view.findViewById(R.id.listview)

        val buttonPlant: Button = view.findViewById(R.id.add_button)
        val buttonHarvest: Button = view.findViewById(R.id.sbor_button)
        val history: TextView = view.findViewById(R.id.history)
        val show_result: TextView = view.findViewById(R.id.show_result_check)
        val ButtonInstrument:Button = view.findViewById(R.id.TestInstrumentButton)

        history.text = "0/$PLANS_COUNT_FOR_FINISH"

        //progressBar.setProgress(progress, true)
        fun progress() {
            val get_progressBar = progressBar.getProgress()
            var schet_progressa_po_culturam = Plants.counter
            var schetchik_progressa = 0
            val currentprogress = 1000

            progressBar.max = 1000
            while (schet_progressa_po_culturam >= schetchik_progressa ){
                ObjectAnimator.ofInt(progressBar,"progress",currentprogress)
                    .setDuration(4550)
                    .start()
                schetchik_progressa++

            }
        }
        //progressBar.max = PLANS_COUNT_FOR_FINISH
        //progressBar.progressDrawable.setColorFilter(Color.rgb(0, 191, 50), android.graphics.PorterDuff.Mode.SRC_IN)
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(0, 191, 50)))
        val myCanvasView: ImageView = view.findViewById(R.id.myView)
        myCanvasView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val builderPlant = AlertDialog.Builder(requireContext())
        builderPlant.setTitle("Выберите растение")
        var checkedItem = 0
        builderPlant.setSingleChoiceItems(Plants.plants, checkedItem) { dialog, which ->
            checkedItem = which
        }

        buttonPlant.setOnClickListener {
            val dialog = builderPlant.create()
            dialog.show()
        }
        buttonHarvest.setOnClickListener {

            if (plantMaster.isCanHarvest) {

                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false

                plantMaster.isPlanted = false

               Plants.initFilter()
                val cmData: FloatArray = floatArrayOf(
                    Plants.rline[0], Plants.rline[1], Plants.rline[2], Plants.rline[3], 0f,
                    Plants.gline[0], Plants.gline[1], Plants.gline[2], Plants.gline[3], 0f,
                    Plants.bline[0], Plants.bline[1], Plants.bline[2], Plants.bline[3], 0f,
                    Plants.lline[0], Plants.lline[1], Plants.lline[2], Plants.lline[3], 0f
                )
                myCanvasView.setColorFilter(ColorMatrixColorFilter(cmData))
                myCanvasView.invalidate()
                progressBar.setProgress(0)
            }
        }
        ButtonInstrument.setOnClickListener {
            if (instrumentMaster.instrumentCanBeUsed){
                val builderInstrument = AlertDialog.Builder(requireContext())
                builderInstrument.setTitle("Выберите инструмент к растению "+cultures[checkedItem].name)
                var checkedItemInstrument = 1
                builderInstrument.setSingleChoiceItems(instrumentsString, checkedItemInstrument) { dialog, which ->
                    checkedItemInstrument = which }
                builderInstrument.setPositiveButton("OK") { dialogInstruments, which ->
                    Toast.makeText(requireContext(), instrumentMaster.InstrumentUse(harvesters[checkedItemInstrument], cultures[checkedItem]), LENGTH_SHORT).show()
                    instrumentMaster.instrumentCanBeUsed=false
                }
                builderInstrument.setNegativeButton("Отмена", null)
                val dialogInstrument = builderInstrument.create()
                dialogInstrument.show()
            }
            else{
                Toast.makeText(requireContext(), "Инструмент уже был использован", LENGTH_SHORT).show()
            }
        }

        builderPlant.setPositiveButton("OK") { dialog, which ->
            if (plantMaster.isPlanted == true) {
                Toast.makeText(requireContext(), "Поле уже засажено", Toast.LENGTH_SHORT).show()
            } else {
                plantMaster.isPlanted = true
                plantMaster.isCanHarvest = false
                draw(myCanvasView, buttonHarvest)
                History.plantHistory.add(Plants.cultures[checkedItem])
                Plants.counter++

                //Toast.makeText(this, "${plantMaster.howIsGoodChoice(cultures[checkedItem], cultures[checkedItem+1])}", Toast.LENGTH_SHORT).show()

                progressBar.setProgress(Plants.counter, true)
                if (Plants.counter == PLANS_COUNT_FOR_FINISH) {
                    //dialogEvent(builder, checkedItem)
                    show_result.text = calculateScore().toString()
                    restartGame()
                }
                history.text = (Plants.counter).toString() + "/$PLANS_COUNT_FOR_FINISH"
                progress()
            }
        }
        builderPlant.setNegativeButton("Отмена", null)

        val expandableListView = view.findViewById<ExpandableListView>(R.id.listview)
        expandedListView.let{
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = ExpandableListAdapter(requireContext(), titleList as ArrayList<String>, listData)
            expandableListView.setAdapter(adapter)
            expandableListView.setOnGroupExpandListener { groupPosition ->  }
            expandableListView.setOnGroupCollapseListener { groupPosition ->  }
            expandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                false
            }
        }
        return view
    }

    private fun draw(myCanvasView: ImageView, buttonHarvest: Button) {
        MainScope().launch {
            for (i in 1..9) {
                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false
                buttonHarvest.text = "Созревание..."
                delay(500)
                val cmData: FloatArray = floatArrayOf(
                    Plants.rline[0], Plants.rline[1], Plants.rline[2], Plants.rline[3], 0f,
                    Plants.gline[0], Plants.gline[1], Plants.gline[2], Plants.gline[3], 0f,
                    Plants.bline[0], Plants.bline[1], Plants.bline[2], Plants.bline[3], 0f,
                    Plants.lline[0], Plants.lline[1], Plants.lline[2], Plants.lline[3], 0f
                )
                val mColorMatrix = ColorMatrix(cmData)
                val mfilter = ColorMatrixColorFilter(mColorMatrix)
                myCanvasView.colorFilter = mfilter
                lvlup()
                myCanvasView.invalidate()

            }
            plantMaster.isCanHarvest = true
            buttonHarvest.alpha = 1F
            buttonHarvest.isClickable = true
            buttonHarvest.text = "Собрать урожай"
        }
    }

    private fun restartGame() {
        History.plantHistory.clear()
        Plants.counter = 0
        view?.findNavController()?.navigate(R.id.action_gameFragment_to_resultFragment)
    }

    fun calculateScore(): MutableList<Int> {
        val score = mutableListOf<Int>()
        for (i in 0..History.plantHistory.size - 2) {
            score.add(plantMaster.howIsGoodChoice(History.plantHistory[i], History.plantHistory[i + 1]))
            Log.i("History", score.toString())
        }
        return score
    }

    fun toRate(checkedItem: Int) {
        var rate = "WRONG"
        for (i in 0 until Eventik.solutions.size) {
            if (Eventik.instruments[checkedItem].name == Eventik.solutions[i].name)
                rate = "RIGHT"
            break
        }
        Toast.makeText(requireContext(), rate, Toast.LENGTH_SHORT).show()
    }

    fun lvlup() {
        Plants.rline[1] += 0.15f
        Plants.gline[1] += 0.08f
        Plants.lline[3] += 0.08f
    }

    /*fun dialogEvent(builder:AlertDialog.Builder, checkedItem1: Int){
        var checkedItem = checkedItem1
        builder.setTitle(Eventik.event.eventText+" Выбери инструмент!")
        builder.setSingleChoiceItems(Eventik.instrumentsString, checkedItem) { dialog, which ->
            checkedItem=which
        }
        builder.setPositiveButton("OK") { dialog, which ->
            toRate(checkedItem)
        }
        builder.setNegativeButton("Отмена", null)
        Data.counter =0
    }*/
    fun dialogResult(){
        //plantMaster.howIsGoodChoice(cultures[checkedItem], cultures[checkedItem+1])
    }
    fun EventAppear(){

    }

    val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val row = ArrayList<String>()
            row.add("Адрес: $")
            row.add("Возраст: $")
            row.add("Телефон: $")
            listData["Полная информация"] = row

            return listData
        }
}