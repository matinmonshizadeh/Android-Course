package com.example.project.features.home_activity.presentation.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.databinding.ItemSliderBinding
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponseItem
import com.example.project.features.movie_details.MovieDetailsActivity

class SliderAdapter(
    private val items: List<MovieResponseItem>
) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemSliderBinding.inflate(
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

    inner class ViewHolder(private val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: MovieResponseItem) {
            Glide.with(binding.sliderPoster.context)
                .load(item.moviePoster)
                .into(binding.sliderPoster)
            binding.sliderTitle.text = item.movieTitle
            binding.sliderYear.text = item.movieYear

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