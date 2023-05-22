package com.example.week04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var num = 0;

        binding.btnCount.setOnClickListener{
            num++
            binding.txtCountNum.setText(num.toString())
        }
        binding.btnToast.setOnClickListener{
            //FragmentView(Fragment_1);
        }
        binding.btnRand.setOnClickListener{
            val newFragment = Fragment1()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.container, newFragment)
                .addToBackStack(null)
                .commit()
        }


    }
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }*/
}