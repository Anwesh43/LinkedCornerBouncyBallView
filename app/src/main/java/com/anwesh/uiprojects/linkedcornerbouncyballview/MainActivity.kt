package com.anwesh.uiprojects.linkedcornerbouncyballview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.cornerbouncyballview.CornerBouncyBallView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CornerBouncyBallView.create(this)
    }
}
