package com.example.project.features.home_activity.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.databinding.ItemMovieBinding
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponseItem
import com.example.project.features.movie_details.MovieDetailsActivity

class MovieAdapter(
    private val items: List<MovieResponseItem>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: MovieResponseItem) {
            Glide.with(binding.moviePoster.context)
                .load(item.moviePoster)
                .into(binding.moviePoster)
            binding.movieTitle.text = item.movieTitle
            binding.movieRating.text = item.movieRating
            binding.movieYear.text = item.movieYear
            binding.root.setOnClickListener {
                val context = it.context
                val intent = Intent(context, MovieDetailsActivity::class.java).apply {
                    putExtra("movieId", item.movieId)
                }
                context.startActivity(intent)
            }
        }
    }
}