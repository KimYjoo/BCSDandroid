package com.example.week06

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week06.databinding.ActivityMainBinding
import com.example.week06.databinding.NewdialogBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val dialbinding = NewdialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val names = ArrayList<Item>()

        val newAdapter = NewAdapter(names)
        binding.fabBtn.setOnClickListener{
            val newText = binding.editText.text
            names.add(Item(newText.toString()))
            newAdapter.notifyDataSetChanged()
        }

        binding.recyView.adapter = newAdapter
        binding.recyView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        newAdapter.setItemClickListener(object: NewAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val builder : AlertDialog.Builder = AlertDialog.Builder(v.context)
                builder.setTitle("타이틀입니다")
                    .setMessage("메세지확인")
                    .setPositiveButton("삭제",
                    DialogInterface.OnClickListener{dialog, id ->
                        names.removeAt(position)
                        newAdapter.notifyDataSetChanged()
                        dialog.dismiss()
                    })
                    .setNegativeButton( "취소",
                        DialogInterface.OnClickListener{dialog, id ->
                            dialog.dismiss()
                    })
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }

            override fun onLongClick(v: View, position: Int) {
                val builder : AlertDialog.Builder = AlertDialog.Builder(v.context)
                val dialBinding = NewdialogBinding.inflate(layoutInflater)
                builder.setTitle("타이틀입니다")
                    .setMessage("메세지확인")
                    .setView(dialbinding.root)

                    .setPositiveButton("확인",
                        DialogInterface.OnClickListener{dialog, id ->
                            names[position] = Item(dialBinding.longClickDialogEditText.text.toString())
                            newAdapter.notifyDataSetChanged()
                            dialog.dismiss()
                        })
                    .setNegativeButton( "취소",
                        DialogInterface.OnClickListener{dialog, id ->
                            dialog.dismiss()
                    })
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }

        })

    }
}