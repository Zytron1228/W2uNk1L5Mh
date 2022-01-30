package com.example.w2unk1l5mh

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

var music1: MediaPlayer? = null
var music2: MediaPlayer? = null
var music3: MediaPlayer? = null
var music4: MediaPlayer? = null
var music5: MediaPlayer? = null
var music6: MediaPlayer? = null

class  MainActivity : AppCompatActivity() {//    android:background="#FF0084"

    private lateinit var viewLayout: ConstraintLayout
    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewLayout = findViewById(R.id.theScreen)
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
        println("ඞ")
        rotatoPotato()
        flashLoop()

        if (music1 == null) {
             music1 = MediaPlayer.create(this, R.raw.aaaaaaaaaaa)
                                                                       music1!!.isLooping = true
             music1!!.start()
        } else music1!!.start()

        if (music2 == null) {
            music2 = MediaPlayer.create(this, R.raw.squidgameroll)
            music2!!.isLooping = true
            music2!!.start()
        } else music2!!.start()

        if (music3 == null) {
            music3 = MediaPlayer.create(this, R.raw.loudrickroll)
            music3!!.isLooping = true
            music3!!.start()
        } else music3!!.start()

        //AAAAAAAAAAAAAAAAAAA

        if (music4 == null) {
            music4 = MediaPlayer.create(this, R.raw.thetrapaaa)
            music4!!.isLooping = true
            music4!!.start()
        } else music4!!.start()

        if (music5 == null) {
            music5 = MediaPlayer.create(this, R.raw.loudroll)
            music5!!.isLooping = true
            music5!!.start()
        } else music5!!.start()

        if (music6== null) {
            music6 = MediaPlayer.create(this, R.raw.loudness)
            music6!!.isLooping = true
            music6!!.start()
        } else music6!!.start()

    }
    private fun runRotato() {
        rotatoPotato()
        println("potato")
        switchFlashLight(true)

    }
    private fun rotatoPotato() {
         viewLayout.rotation = (-350..350).random().toFloat()
        viewLayout.rotationX = (-45..45).random().toFloat()
        viewLayout.rotationY = (-45..45).random().toFloat()
        println("rotato")
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            runRotato()
            switchFlashLight(false)
        }, 1256)

    }

//    private fun rotateScreen() {
//        val animator = ObjectAnimator.ofFloat(viewLayout, View.ROTATION, -360, 0, -37, 1824, 367, 2, 15, -200, 150)
//        animator.duration = 1500
//        animator.start()
//    }

    private fun flashLoop() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            when((0..50).random()) {

                in 25..50 -> {
                    println("did not  flash")
                }
                in 1..24 -> {
                    switchFlashLight(true)
                    println("flashed .")
                    val handler2 = Handler(Looper.getMainLooper())
                    handler2.postDelayed({
                        switchFlashLight(false)
                    }, (3..400).random().toLong())
                }
            }
            flashLoop()
        }, 1000)
    }

    private fun switchFlashLight(status: Boolean) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraId, status)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    }

