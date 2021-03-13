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
import com.polich.kneecap.data.Plants.counter
import com.polich.kneecap.data.Plants.gline
import com.polich.kneecap.data.Plants.initFilter
import com.polich.kneecap.data.Plants.isCanHarvest
import com.polich.kneecap.data.Plants.isPlanted
import com.polich.kneecap.data.Plants.lline
import com.polich.kneecap.data.Plants.plants
import com.polich.kneecap.data.Plants.rline
import com.polich.kneecap.data.TemporaryObject.amountOfHappendEvents
import com.polich.kneecap.data.TemporaryObject.playerScore
import com.polich.kneecap.data.TemporaryObject.progressBarNeedsToBeFilled
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
    var leveeel: String = "1"

    val plantMaster = PlantMaster()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        val progressBar: ProgressBar = view.findViewById(R.id.progress_bar)

        val sd = activity?.assets?.openFd("villageSongCut.mp3")
        val soundPool: SoundPool = buildSoundPool(100000)
        val zvon = soundPool.load(sd, 1)

        val buttonPlant: Button = view.findViewById(R.id.add_button)
        val buttonHarvest: Button = view.findViewById(R.id.sbor_button)
        val history: TextView = view.findViewById(R.id.history)
        val show_result: TextView = view.findViewById(R.id.show_result_check)
        val eventFloatingActionButton:FloatingActionButton = view.findViewById(R.id.eventFloatingActionButton)

        history.text = "$counter/$PLANS_COUNT_FOR_FINISH"
        if (progressBarNeedsToBeFilled){progressBar.setProgress(1000, false)}

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


        }

        builderPlant.setSingleChoiceItems(plants, checkedItem) { dialog, which ->
            checkedItem = which
        }

        buttonPlant.setOnClickListener {
//            soundPool.play(zvon, 1f, 1f, 1, 0, 1f)
//            val dialog = builderPlant.create()
//            dialog.show()
            view?.findNavController()?.navigate(R.id.action_gameFragment_to_eventFragment)
        }

        buttonHarvest.setOnClickListener {
            if (isCanHarvest) {
                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false
                progressBarNeedsToBeFilled = false
                isPlanted = false
                initFilter()
                myCanvasView.setColorFilter(ColorMatrixColorFilter(cmDataInvalidate()))
                myCanvasView.invalidate()
                progressBar.setProgress(0)
                if (counter == PLANS_COUNT_FOR_FINISH) {
                    calculateScore().toString()
                    restartGame()
                }
            }
            else{
                initFilter()
                myCanvasView.setColorFilter(ColorMatrixColorFilter(cmDataInvalidate()))
                myCanvasView.invalidate()
            }
        }

        fun EventButtonAppear(eventFloatingActionButton: FloatingActionButton, delay: Long) {
            Handler(Looper.getMainLooper()).postDelayed({
                eventFloatingActionButton.visibility = VISIBLE
            }, delay)
            Handler(Looper.getMainLooper()).postDelayed({
                eventFloatingActionButton.visibility = GONE
                buttonHarvest.isEnabled = true
                buttonHarvest.isClickable = true
                buttonHarvest.text = "Собрать Урожай"
            }, 10000)
        }

        builderPlant.setPositiveButton("OK") { dialog, which ->
            if (isPlanted == true) {
                Toast.makeText(requireContext(), "Поле уже засажено", Toast.LENGTH_SHORT).show()
            } else {
                progressBarNeedsToBeFilled = true
                var delay = nextLong(2000)+2000
                val bundle = Bundle()

                bundle.putString("level",requireArguments().getString("level"))
                bundle.putString("POLE", requireArguments().getString("POLE"))

                val level = bundle.getString("POLE")
                if(level != null){
                    when(level){
                        "1" -> amountOfHappendEvents = LevelDif.levelSection[0].amountOfEvents
                        "2" -> amountOfHappendEvents = LevelDif.levelSection[1].amountOfEvents
                        "3" ->  amountOfHappendEvents = LevelDif.levelSection[2].amountOfEvents
                    }
                    when(level){
                        "1" -> leveeel = LevelDif.levelSection[0].name
                        "2" -> leveeel = LevelDif.levelSection[1].name
                        "3" ->  leveeel = LevelDif.levelSection[2].name
                    }
                }

                amountOfHappendEvents-=1
                if (amountOfHappendEvents>0){
                    EventButtonAppear(eventFloatingActionButton, delay)
                }
                isPlanted = true
                isCanHarvest = false
                initFilter()
                draw(myCanvasView, buttonHarvest)
                History.plantHistory.add(Plants.cultures[checkedItem])
                counter++

                progressBar.setProgress(counter, true)
                history.text = (counter).toString() + "/$PLANS_COUNT_FOR_FINISH"
                progress()
            }
        }
        builderPlant.setNegativeButton("Отмена", null)

        return view
    }

    private fun draw(myCanvasView: ImageView, buttonHarvest: Button) {
        MainScope().launch {
            for (i in 1..46) {
                buttonHarvest.alpha = 0.5F
                buttonHarvest.isClickable = false
                buttonHarvest.text = "Созревание..."
                delay(90)
                val mColorMatrix = ColorMatrix(cmDataInvalidate())
                val mfilter = ColorMatrixColorFilter(mColorMatrix)
                myCanvasView.colorFilter = mfilter
                lvlup()
                myCanvasView.invalidate()
            }
            isCanHarvest = true
            buttonHarvest.alpha = 1F
            buttonHarvest.isClickable = false
            if (amountOfHappendEvents>0){
                buttonHarvest.isEnabled = false
                buttonHarvest.text = "Решите проблему"
            }
            else{
                buttonHarvest.isEnabled = true
                buttonHarvest.isClickable = true
                buttonHarvest.text = "Собрать урожай"
            }
        }
    }

    private fun restartGame() {
        counter = 0
        val bundle = Bundle()
        bundle.putString("levelNow", leveeel)
        view?.findNavController()?.navigate(R.id.action_gameFragment_to_resultFragment, bundle)
    }

    fun calculateScore(){
        for (i in 0..History.plantHistory.size-2) {
            playerScore += plantMaster.howIsGoodChoice(History.plantHistory[i], History.plantHistory[i + 1])
        }
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
        rline[1] += 0.024f
        gline[1] += 0.0120f
        lline[3] += 0.0120f
        cmDataInvalidate()
    }
}
