package com.polich.kneecap

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.Nullable


class SongService : Service() {
    //var player: MediaPlayer? = null
    private var mPlayer: MediaPlayer? = null

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(
            this, "Служба создана",
            Toast.LENGTH_SHORT
        ).show()
        //mPlayer = MediaPlayer.create(this, R.raw.villageSong)
        mPlayer!!.isLooping = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(
            this, "Служба запущена",
            Toast.LENGTH_SHORT
        ).show()
        mPlayer!!.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(
            this, "Служба остановлена",
            Toast.LENGTH_SHORT
        ).show()
        mPlayer!!.stop()
    }
}