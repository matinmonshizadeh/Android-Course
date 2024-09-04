package com.example.project.features.search_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.databinding.ActivitySearchBinding
import com.example.project.features.favorite_activity.FavoriteActivity
import com.example.project.features.home_activity.HomeActivity
import com.example.project.features.home_activity.presentation.ui.adapter.MovieAdapter
import com.example.project.features.search_activity.presentation.viewmodel.SearchViewModel
import com.example.project.features.search_activity.presentation.viewmodel.SearchViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        configureViewModel()
    }

    private fun initialBinding() {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        searchViewModel =
            ViewModelProvider(this, SearchViewModelFactory())[SearchViewModel::class.java]
    }

    private fun configureViewModel() {
        searchViewModel.movies.observe(this) { movies ->
            val movieAdapter = MovieAdapter(movies.data)

            binding.searchRecyclerView.adapter = movieAdapter
            binding.searchRecyclerView.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Implement query submit handling if needed
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    callAPI(query)
                }
                return true
            }
        })

        binding.bottomNavigation.selectedItemId = R.id.search_page

        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home_page -> {
                    val intent = Intent(this@SearchActivity, HomeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.favorite_page -> {
                    val intent = Intent(this@SearchActivity, FavoriteActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }

    private fun callAPI(query: String) {
        CoroutineScope(Dispatchers.Main).launch {
            searchViewModel.getMoviesBasedOnQuery(query)
        }
    }

}
