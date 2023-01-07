package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

/**
 * Adapter needed to populate the data in the RecyclerView. Its role is to CONVERT AN OBJECT AT A
 * POSITION INTO A (LIST ROW) ITEM to be inserted.
 */
class SleepNightAdapter(val clickListener: SleepNightListener) : ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {

    /**
     * Needed to inflate the item layout and create the holder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent) //create a new view holder
    }

    /**
     * Needed to set the view attributes based on the data.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    /**
     * ViewHolder class (encapsulation)
     */
    class ViewHolder private constructor(private val binding: ListItemSleepNightBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: SleepNight, clickListener: SleepNightListener) {
            binding.sleep = item
            binding.clickListener = clickListener
            binding.executePendingBindings() //optimization
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class SleepNightDiffCallback: DiffUtil.ItemCallback<SleepNight>() {
        override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem.nightId == newItem.nightId
        }

        override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem == newItem
        }

    }

    /**
     * onClick method will be triggered when the user clicks on an item with the selected item.
     */
    class SleepNightListener(val clickListener: (sleepId: Long) -> Unit){
        fun onClick(night: SleepNight) = clickListener(night.nightId)
    }


}