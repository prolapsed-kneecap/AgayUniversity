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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.polich.kneecap.MainActivity
import com.polich.kneecap.PlantMaster
import com.polich.kneecap.R
import com.polich.kneecap.data.History
import com.polich.kneecap.data.Plants
import com.polich.kneecap.data.Plants.cmDataInvalidate
import com.polich.kneecap.data.Plants.counter
import com.polich.kneecap.data.Plants.gline
import com.polich.kneecap.data.Plants.isCanHarvest
import com.polich.kneecap.data.Plants.lline
import com.polich.kneecap.data.Plants.rline
import com.polich.kneecap.data.TemporaryObject.amountOfHappendEvents
import com.polich.kneecap.data.TemporaryObject.playerScore
import com.polich.kneecap.data.TemporaryObject.progressBarNeedsToBeFilled
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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

        val history: TextView = view.findViewById(R.id.history)
        val show_result: TextView = view.findViewById(R.id.show_result_check)
        var operationsButton:FloatingActionButton = view.findViewById(R.id.operationsButton)
        (requireActivity() as MainActivity).setAppBarTitle("Поле")
        history.text = "$counter/$PLANS_COUNT_FOR_FINISH"

        if (progressBarNeedsToBeFilled){progressBar.setProgress(1000, false)}

        fun progress() {
            progressBar.max = 1000
            var schet_progressa_po_culturam = Plants.counter
            var schetchik_progressa = 0
            val currentprogress = 1000
            while (schet_progressa_po_culturam >= schetchik_progressa ){
                ObjectAnimator.ofInt(progressBar,"progress",currentprogress)
                    .setDuration(45500)
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
        val rootView: View = inflater.inflate(R.layout.fragment_instruments, container, false)
        operationsButton.setOnClickListener {v->
            view?.findNavController()?.navigate(R.id.action_gameFragment_to_fragmentCategories)
            (requireActivity() as MainActivity).setAppBarTitle("Категории")
            operationsButton.setBackgroundColor(R.drawable.ic_baseline_remove_24)
            }
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
    fun lvlup() {
        rline[1] += 0.024f
        gline[1] += 0.0120f
        lline[3] += 0.0120f
        cmDataInvalidate()
    }
//    fun deleteFromBackStack(){
//        findNavController().popBackStack(R.id.levelSelectionFragment, true)
//        findNavController().popBackStack(R.id.eventFragment, true)
//    }
}
