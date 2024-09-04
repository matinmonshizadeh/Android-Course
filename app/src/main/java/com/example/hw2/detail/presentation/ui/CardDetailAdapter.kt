package com.example.hw2.detail.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.R
import com.example.hw2.databinding.ActivityCardDetailBinding
import com.example.hw2.databinding.ItemCardBinding
import com.example.hw2.databinding.ItemCardDetailBinding
import com.example.hw2.detail.data.model.CardDetail
import com.example.hw2.home.data.model.Card


class CardDetailAdapter() : RecyclerView.Adapter<CardDetailAdapter.CardDetailViewHolder>(){

    private var cardDetailList = emptyList<CardDetail>()

    fun setCardDetailList(list: List<CardDetail>){
        cardDetailList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDetailViewHolder {
        val binding = ItemCardDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDetailViewHolder, position: Int) {
        holder.bindData(cardDetailList[position])
    }

    override fun getItemCount(): Int = cardDetailList.size

    inner class CardDetailViewHolder(private val binding: ItemCardDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bindData(cardDetail: CardDetail) {
            with(binding) {
                textItemCardDetailSubject.text = cardDetail.subject
                textItemCardDetailValue.text = cardDetail.value
            }
        }
    }





}


















//class CardDetailAdapter(private val cardDetails: ArrayList<CardDetail>) :
//    RecyclerView.Adapter<CardDetailAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        private val cardDetailValue = itemView.findViewById<TextView>(R.id.text_item_card_detail_value)
//        private val cardDetailSubject = itemView.findViewById<TextView>(R.id.text_item_card_detail_subject)
//
//
//        @SuppressLint("SetTextI18n")
//        fun bindData(position: Int) {
//            cardDetailValue.text = cardDetails[position].value
//            cardDetailSubject.text = cardDetails[position].subject
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_detail, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = cardDetails.size
//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindData(position)
//    }
//
//}