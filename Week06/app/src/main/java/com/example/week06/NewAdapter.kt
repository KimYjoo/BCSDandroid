package com.example.week06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
data class Item (val text : String)

class NewAdapter (private val dataSet : ArrayList<Item>): RecyclerView.Adapter<NewAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView
        init{
            textView = view.findViewById(R.id.textV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].text
        viewHolder.textView.setOnClickListener{
            itemClickListener.onClick(it, position)
        }
        viewHolder.textView.setOnLongClickListener{
            itemClickListener.onLongClick(it,position)
            false
        }
    }
    interface OnItemClickListener{
        fun onClick(v: View, position: Int)
        fun onLongClick(v:View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

    override fun getItemCount() = dataSet.size
}