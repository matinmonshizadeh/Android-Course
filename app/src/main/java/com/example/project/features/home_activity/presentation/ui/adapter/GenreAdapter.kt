package com.example.project.features.home_activity.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.features.genre_movies_activity.GenreMoviesActivity
import com.example.project.features.home_activity.domain.data.model.genres.GenreResponseItem
//import com.roodaki.imdbandroidapp.databinding.ItemGenreBinding
import com.example.project.databinding.ItemGenreBinding

class GenreAdapter(private val items: List<GenreResponseItem>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreViewHolder {
        val view =
            ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class GenreViewHolder(private val binding: ItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: GenreResponseItem) {
            binding.genreName.text = item.genreName
            binding.root.setOnClickListener {
                val context = it.context
                val intent = Intent(context, GenreMoviesActivity::class.java).apply {
                    putExtra("genreId", item.genreId)
                }
                context.startActivity(intent)
            }
        }
    }
}