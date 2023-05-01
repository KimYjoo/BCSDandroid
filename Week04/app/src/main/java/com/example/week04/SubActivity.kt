package com.example.week04

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val intent = getIntent()
        val descriptionText = findViewById<TextView>(R.id.txt_randDescription)
        var randnum = intent.getIntExtra("RandNum",0)
        var text = getString(R.string.rand_message,randnum)
        descriptionText.setText(text)

        val randText = findViewById<TextView>(R.id.txt_randNum)
        randnum = (0..randnum).random()
        randText.setText(randnum.toString())


    }
    override fun onBackPressed(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}