package com.kofu.brighton.cryptomint.ui.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.databinding.CurrencyListItemBinding

class CurrencyAdapter : ListAdapter<Currency, CurrencyViewHolder>(CURRENCY_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemBinding =
            CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object{
        val CURRENCY_COMPARATOR = object : DiffUtil.ItemCallback<Currency>() {
            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem::class == newItem::class
            }

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                var correct: Boolean

                correct = TextUtils.equals(oldItem.symbol, newItem.symbol)
                correct = TextUtils.equals(oldItem.name, newItem.name)
                correct = TextUtils.equals(oldItem.nameFull, newItem.nameFull)
                correct = TextUtils.equals(oldItem.maxSupply, newItem.maxSupply)
                correct = TextUtils.equals(oldItem.iconURL, newItem.iconURL)

                return correct
            }
        }
    }
}

class CurrencyViewHolder(private val itemBinding: CurrencyListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Currency) {
        itemBinding.iconImageView.load(item.iconURL)
        itemBinding.cNameTextview.text = item.name

        val winLossPercentage = ((item.rate - item.previousRate)/item.rate)*100

        itemBinding.changePercentageTextview.text = "$winLossPercentage"
        itemBinding.balanceBreakdownTextview.text = "${item.numberOfCoins} x ${item.rate}"
        itemBinding.totalBalanceTextview.text = "$ ${item.numberOfCoins * item.rate}"
    }
}
