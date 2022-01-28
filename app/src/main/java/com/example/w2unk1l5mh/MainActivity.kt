package com.example.w2unk1l5mh

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

var music1: MediaPlayer? = null
var music2: MediaPlayer? = null
var rotZ = (0..360).random().toFloat()
var rotX = (0..360).random().toFloat()
var rotY = (0..360).random().toFloat()

class  MainActivity : AppCompatActivity() {//    android:background="#FF0084"

    private lateinit var viewLayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("ඞ")
        rotatoPotato()

        if (music1 == null) {
             music1 = MediaPlayer.create(this, R.raw.aaaaaaaaaaaa)
                                                                       music1!!.isLooping = true
             music1!!.start()
        } else music1!!.start()

    if (music2 == null) {
        music2 = MediaPlayer.create(this, R.raw.squidgameroll)
        music2!!.isLooping = true
        music2!!.start()
    } else music2!!.start()


    }
    fun runRotato() {
        rotatoPotato()
    }
    fun rotatoPotato() {
         viewLayout.rotation = rotZ
        viewLayout.rotationX = rotX
        viewLayout.rotationY = rotY
//        val handler = Handler(Looper.getMainLooper())
//        handler.postDelayed({
//            runRotato()
//        }, 3000)

            }
    }

