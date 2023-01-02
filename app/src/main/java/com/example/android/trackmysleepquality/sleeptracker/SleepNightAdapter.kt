package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.TextItemViewHolder
import com.example.android.trackmysleepquality.database.SleepNight

/**
 * Adapter needed to populate the data in the RecyclerView. Its role is to CONVERT AN OBJECT AT A
 * POSITION INTO A (LIST ROW) ITEM to be inserted.
 */
class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<SleepNight>()
    set(value) {
        field = value
        notifyDataSetChanged()//notifying the adapter that dataset has changed.
    }

    /**
     * Needed to inflate the item layout and create the holder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view) //see Util.kt
    }

    /**
     * Needed to set the view attributes based on the data.
     */
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.sleepQuality.toString()
    }

    /**
     * Needed to determine the number of items.
     */
    override fun getItemCount(): Int {
        return data.size
    }

}