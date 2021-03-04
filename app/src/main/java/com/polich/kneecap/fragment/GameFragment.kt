package com.polich.kneecap.fragment

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.polich.kneecap.*
import com.polich.kneecap.data.*
import com.polich.kneecap.data.Plants.cmDataInvalidate
import com.polich.kneecap.data.Plants.gline
import com.polich.kneecap.data.Plants.initFilter
import com.polich.kneecap.data.Plants.lline
import com.polich.kneecap.data.Plants.rline
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random.Default.nextLong

class GameFragment : Fragment() {

    fun buildSoundPool(maxStreams: Int): SoundPool =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val attrs = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            SoundPool.Builder()
                .setAudioAttributes(attrs)
                .setMaxStreams(maxStreams)
                .build()
        } else {
            SoundPool(maxStreams, AudioManager.STREAM_MUSIC, 0)
        }

    val PLANS_COUNT_FOR_FINISH = LevelSelectionFragment.yearsPlants

    val plantMaster = PlantMaster()
    val instrumentMaster = InstrumentMaster()
    val eventFragment:Fragment = EventFragment()
    internal var titleList: List<String> ?= null
    internal var adapter: ExpandableListAdapter?= null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        val progressBar: ProgressBar = view.findViewById(R.id.progress_bar)
        //val expandedListView: ExpandableListView = view.findViewById(R.id.listview)

        val sd = activity?.assets?.openFd("villageSongCut.mp3")
        val soundPool: SoundPool = buildSoundPool(100000)
        val zvon = soundPool.load(sd, 1)

        val buttonPlant: Button = view.findViewById(R.id.add_button)
        val buttonHarvest: Button = view.findViewById(R.id.sbor_button)
        val history: TextView = view.findViewById(R.id.history)
        val show_result: TextView = view.findViewById(R.id.show_result_check)
        val eventFloatingActionButton:FloatingActionButton = view.findViewById(R.id.eventFloatingActionButton)

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
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(0, 191, 50)))
        val myCanvasView: ImageView = view.findViewById(R.id.myView)
        myCanvasView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        initFilter()
        myCanvasView.setColorFilter(ColorMatrixColorFilter(cmDataInvalidate()))
        myCanvasView.invalidate()

        val builderPlant = AlertDialog.Builder(requireContext())
        builderPlant.setTitle("Выберите растение")
        var checkedItem = 0

        var INTevent = 0

        eventFloatingActionButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("level",requireArguments().getString("level"))
            bundle.putString("POLE", requireArguments().getString("POLE"))

            val level = bundle.getString("POLE")
            if(level != null){
                when(level){
                    "easy" -> INTevent = LevelDif.levelSection[0].amountOfEvents
                    "medium" -> INTevent = LevelDif.levelSection[1].amountOfEvents
                    "hard" ->  INTevent = LevelDif.levelSection[2].amountOfEvents
                }
            }

            view?.findNavController()?.navigate(R.id.action_gameFragment_to_eventFragment, bundle)
        }

        builderPlant.setSingleChoiceItems(Plants.plants, checkedItem) { dialog, which ->
            checkedItem = which
        }

        buttonPlant.setOnClickListener {
            soundPool.play(zvon, 1f, 1f, 1, 0, 1f)
            val dialog = builderPlant.create()
            dialog.show()
        }

        buttonHarvest.setOnClickListener {
            if (plantMaster.isCanHarvest) {
                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false

                plantMaster.isPlanted = false

                myCanvasView.setColorFilter(ColorMatrixColorFilter(cmDataInvalidate()))
                myCanvasView.invalidate()
                progressBar.setProgress(0)
                if (Plants.counter == PLANS_COUNT_FOR_FINISH) {
                    show_result.text = calculateScore().toString()
                    restartGame()
                }
            }
        }
        /*ButtonInstrument.setOnClickListener {
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
        }*/

        builderPlant.setPositiveButton("OK") { dialog, which ->
            if (plantMaster.isPlanted == true) {
                Toast.makeText(requireContext(), "Поле уже засажено", Toast.LENGTH_SHORT).show()
            } else {
                var delay = nextLong(2000)+2000
                val bundle = Bundle()

                bundle.putString("level",requireArguments().getString("level"))
                bundle.putString("POLE", requireArguments().getString("POLE"))

                val level = bundle.getString("POLE")
                if(level != null){
                    when(level){
                        1.toString() -> TemporaryObject.amountOfHappendEvents = LevelDif.levelSection[0].amountOfEvents
                        2.toString() -> TemporaryObject.amountOfHappendEvents = LevelDif.levelSection[1].amountOfEvents
                        3.toString() ->  TemporaryObject.amountOfHappendEvents = LevelDif.levelSection[2].amountOfEvents
                    }
                }
                TemporaryObject.amountOfHappendEvents-=1
                if (TemporaryObject.amountOfHappendEvents>0){
                    EventButtonAppear(eventFloatingActionButton, delay)
                }
                plantMaster.isPlanted = true
                plantMaster.isCanHarvest = false
                initFilter()
                draw(myCanvasView, buttonHarvest)
                History.plantHistory.add(Plants.cultures[checkedItem])
                Plants.counter++

                //Toast.makeText(this, "${plantMaster.howIsGoodChoice(cultures[checkedItem], cultures[checkedItem+1])}", Toast.LENGTH_SHORT).show()

                progressBar.setProgress(Plants.counter, true)
                history.text = (Plants.counter).toString() + "/$PLANS_COUNT_FOR_FINISH"
                progress()
            }
        }
        builderPlant.setNegativeButton("Отмена", null)

        return view
    }

    private fun draw(myCanvasView: ImageView, buttonHarvest: Button) {
        MainScope().launch {
            for (i in 1..9) {
                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false
                buttonHarvest.text = "Созревание..."
                delay(500)
                val mColorMatrix = ColorMatrix(cmDataInvalidate())
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

    fun EventButtonAppear(eventFloatingActionButton: FloatingActionButton, delay: Long) {
        Handler(Looper.getMainLooper()).postDelayed({
            eventFloatingActionButton.visibility = VISIBLE
        }, delay)
        Handler(Looper.getMainLooper()).postDelayed({
            eventFloatingActionButton.visibility = GONE
        }, 20000)
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
        rline[1] += 0.08f
        gline[1] += 0.04f
        lline[3] += 0.04f
        cmDataInvalidate()
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
    fun dialogResult() {
        //plantMaster.howIsGoodChoice(cultures[checkedItem], cultures[checkedItem+1])
    }
    fun EventAppear(){

    }
}
