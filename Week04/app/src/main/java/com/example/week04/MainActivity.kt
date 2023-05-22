package com.example.week04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countNum = findViewById<TextView>(R.id.txt_countNum)
        val increase = findViewById<Button>(R.id.btn_count)
        var num = 0;
        val toastM = findViewById<Button>(R.id.btn_toast)
        val rand = findViewById<Button>(R.id.btn_rand)
        increase.setOnClickListener{
            num++
            countNum.setText(num.toString())
        }
        toastM.setOnClickListener{
            Toast.makeText(getApplicationContext(), getString(R.string.t_message), Toast.LENGTH_SHORT).show()
        }
        rand.setOnClickListener{
            val nextIntent = Intent(this, SubActivity::class.java)
            nextIntent.putExtra("RandNum", num)
            startActivity(nextIntent)
        }


    }
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }*/
}