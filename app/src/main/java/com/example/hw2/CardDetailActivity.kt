package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.databinding.ActivityCardDetailBinding
import com.example.hw2.databinding.ActivityMainBinding
import com.example.hw2.detail.data.model.CardDetail
import com.example.hw2.detail.presentation.ui.CardDetailAdapter
import com.example.hw2.detail.presentation.viewmodel.CardDetailViewModel
import com.example.hw2.home.data.model.Filter
import com.example.hw2.home.presentation.ui.FilterAdapter

class CardDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardDetailBinding
    private val cardDetailViewModel: CardDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        configListeners()


//        val cardDetailList = arrayListOf(
//            CardDetail("500", "Square foot"),
//            CardDetail("4", "Bedrooms"),
//            CardDetail("2", "Bathrooms"),
//            CardDetail("1", "Toilet"),
//            CardDetail("2", "Garage"),
//            CardDetail("1", "Elevator"),
//
//        )


        val extras = intent.extras ?: return

        binding.apply {
            cardDetailMainImage.setImageResource(extras.getInt("image", R.drawable.house1))
            cardDetailPrice.text = extras.getString("price", "NA")
            cardDetailLocation.text = extras.getString("location", "NA")
        }


        val cardDetailAdapter = CardDetailAdapter()
        binding.recyclerCardDetail.apply {
            adapter = cardDetailAdapter
            layoutManager = LinearLayoutManager(this@CardDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        }

        cardDetailViewModel.getCardDetails().observe(this, Observer { cardDetailsList ->
            cardDetailAdapter.setCardDetailList(cardDetailsList)
        })




//        val adapterCardDetail = CardDetailAdapter(cardDetailList)
//        binding.recyclerCardDetail.adapter = adapterCardDetail
//        binding.recyclerCardDetail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }




    private fun initialBinding() {
        binding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configListeners() {
        binding.cardDetailBackIcon.setOnClickListener {
            val intent = Intent(this@CardDetailActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }





}