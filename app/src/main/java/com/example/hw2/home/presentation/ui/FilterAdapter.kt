package com.example.hw2.home.presentation.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.R
import com.example.hw2.home.data.model.Filter


class FilterAdapter : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>(){
    private var filters = listOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter, parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bindData(filters[position])
    }

    override fun getItemCount(): Int = filters.size

    fun setData(filters: List<String>){
        this.filters = filters
        notifyDataSetChanged()
    }

    inner class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val subjectText = itemView.findViewById<TextView>(R.id.text_filter)

        fun bindData(filter: String) {
            subjectText.text = filter
        }
    }




}







//class FilterAdapter(private val filters: ArrayList<Filter>) :
//    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val subjectText = itemView.findViewById<TextView>(R.id.text_filter)
//
//        @SuppressLint("SetTextI18n")
//        fun bindData(position: Int) {
//            subjectText.text = filters[position].subject
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filter, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = filters.size
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindData(position)
//    }
//
//}