package com.example.hw2.home.presentation.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.CardDetailActivity
import com.example.hw2.R
import com.example.hw2.databinding.ItemCardBinding
import com.example.hw2.home.data.model.Card

class CardAdapter(
    private val listener: (Card) -> Unit
) : RecyclerView.Adapter<CardAdapter.CardViewHolder>(){

    private var cardList = emptyList<Card>()

    fun setCardList(list: List<Card>){
        cardList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindData(cardList[position])
    }

    override fun getItemCount(): Int = cardList.size

    inner class CardViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                listener(cardList[adapterPosition])
            }
        }

        fun bindData(card: Card) {
            with(binding) {
                itemCardImage.setImageResource(card.image)
                itemCardPrice.text = card.price
                itemCardLocation.text = card.location
                itemCardBedrooms.text = card.bedrooms
                itemCardBathrooms.text = card.bathrooms
                itemCardArea.text = card.area
            }
        }
    }





}





















//class CardAdapter(private val cards: ArrayList<Card>) :
//    RecyclerView.Adapter<CardAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val cardImage = itemView.findViewById<ImageView>(R.id.item_card_image)
//        private val cardPrice = itemView.findViewById<TextView>(R.id.item_card_price)
//        private val cardLocation = itemView.findViewById<TextView>(R.id.item_card_location)
//        private val cardBedrooms = itemView.findViewById<TextView>(R.id.item_card_bedrooms)
//        private val cardBathrooms = itemView.findViewById<TextView>(R.id.item_card_bathrooms)
//        private val cardArea = itemView.findViewById<TextView>(R.id.item_card_area)
//
//        init {
//            itemView.setOnClickListener {
//                val position = adapterPosition
//                if (position != RecyclerView.NO_POSITION) {
//                    val intent = Intent(itemView.context, CardDetailActivity::class.java).apply {
//                        // Pass necessary data to the detail activity using intent extras
//                        putExtra("CARD_IMAGE", cards[position].image)
//                        putExtra("CARD_PRICE", cards[position].price)
//                        putExtra("CARD_LOCATION", cards[position].location)
//                        putExtra("CARD_BEDROOMS", cards[position].bedrooms)
//                        putExtra("CARD_BATHROOMS", cards[position].bathrooms)
//                        putExtra("CARD_AREA", cards[position].area)
//                    }
//                    itemView.context.startActivity(intent)
//                }
//            }
//        }
//
//
//
//        @SuppressLint("SetTextI18n")
//        fun bindData(position: Int) {
//            cardImage.setImageResource(cards[position].image)
//            cardPrice.text = cards[position].price
//            cardLocation.text = cards[position].location
//            cardBedrooms.text = cards[position].bedrooms
//            cardBathrooms.text = cards[position].bathrooms
//            cardArea.text = cards[position].area
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = cards.size
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindData(position)
//    }
//
//}