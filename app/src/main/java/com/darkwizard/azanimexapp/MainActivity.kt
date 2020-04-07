package com.darkwizard.azanimexapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //fun getTypeFace() : Typeface =Typeface.createFromAsset(assets,"fonts/orbitron_medium.ttf")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //textLogo.typeface = getTypeFace()
        //textSlogan.typeface = getTypeFace()
    }
}
