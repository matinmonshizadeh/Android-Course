package com.example.hw2

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.databinding.ActivityMainBinding
import com.example.hw2.home.data.model.Filter
import com.example.hw2.home.presentation.ui.FilterAdapter
import com.example.hw2.home.data.model.Card
import com.example.hw2.home.presentation.ui.CardAdapter
import com.example.hw2.home.presentation.viewmodel.CardViewModel
import com.example.hw2.home.presentation.viewmodel.FilterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val filterViewModel: FilterViewModel by viewModels()
    private val cardViewModel: CardViewModel by viewModels()






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
//        configListeners()




//        val filterList = arrayListOf(
//            Filter("< $220.000"),
//            Filter("For Sale"),
//            Filter("With Garage"),
//            Filter("With Elevator"),
//            Filter("Has Pool"),
//            Filter("More than 4 beds"),
//        )




//        val cardList = arrayListOf(
//            Card(R.drawable.house1, "200.000", "Potrero Hil", "4", "2", "1.210"),
//            Card(R.drawable.house2, "120.000", "Alice Griffith", "2", "1", "1.340"),
//            Card(R.drawable.house3, "340.000", "Sunnydale", "5", "2", "1.510"),
//            Card(R.drawable.house4, "510.000", "Potrero Hil", "6", "3", "2.210"),
//            Card(R.drawable.house5, "170.000", "Sunnydale", "3", "2", "1.570"),
//        )


        val filterAdapter = FilterAdapter()
        binding.recyclerFilter.apply {
            adapter = filterAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }

        filterViewModel.getFilters().observe(this, Observer {filtersList ->
            val filters = filtersList.map { it.subject }
            filterAdapter.setData(filters)
        })



        val cardAdapter = CardAdapter { card ->
            val intent = Intent(this, CardDetailActivity::class.java).apply {
                putExtra("image", card.image)
                putExtra("price", card.price)
                putExtra("location", card.location)
                putExtra("bedrooms", card.bedrooms)
                putExtra("bathrooms", card.bathrooms)
                putExtra("area", card.area)
            }
            startActivity(intent)
        }

        binding.recyclerCard.apply {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        cardViewModel.getCards().observe(this, Observer { cardList ->
            cardAdapter.setCardList(cardList)
        })





//        val adapterFilter = FilterAdapter(filterList)
//        binding.recyclerFilter.adapter = adapterFilter
//        binding.recyclerFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



//
//        val adapterCard = CardAdapter(cardList)
//        binding.recyclerCard.adapter = adapterCard
//        binding.recyclerCard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }





    private fun initialBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configListeners() {
        binding.recyclerCard.setOnClickListener {
//            startActivity(Intent(this@MainActivity, CardDetailActivity::class.java))
            Intent(this, CardDetailActivity::class.java).also{
                startActivity(it)
            }
        }
    }




}
