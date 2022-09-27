package com.kofu.brighton.cryptomint.ui.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kofu.brighton.cryptomint.R
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.databinding.CurrencyListItemBinding

class CurrencyAdapter(private val clickListener: (symbol: String) -> Unit) :
    ListAdapter<Currency, CurrencyViewHolder>(CURRENCY_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemBinding =
            CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
        holder.itemView.setOnClickListener { clickListener(currency.symbol) }
    }

    companion object {
        val CURRENCY_COMPARATOR = object : DiffUtil.ItemCallback<Currency>() {
            override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return oldItem::class == newItem::class
            }

            override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
                return (TextUtils.equals(oldItem.symbol, newItem.symbol) &&
                        TextUtils.equals(oldItem.name, newItem.name) &&
                        TextUtils.equals(oldItem.nameFull, newItem.nameFull) &&
                        TextUtils.equals(oldItem.maxSupply, newItem.maxSupply) &&
                        TextUtils.equals(oldItem.iconURL, newItem.iconURL))
            }
        }
    }
}

class CurrencyViewHolder(private val itemBinding: CurrencyListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: Currency) {
        itemBinding.iconImageView.load(item.iconURL)
        itemBinding.cNameTextview.text = item.name

        val winLossPercentage = ((item.rate - item.previousRate) / item.rate) * 100
        itemBinding.changePercentageTextview.text = "${String.format("%.2f", winLossPercentage)} %"
        if (winLossPercentage < 0)
            itemBinding.changePercentageTextview.setTextColor(itemBinding.root.resources.getColor(R.color.loss_red))

        if (winLossPercentage > 0) {
            itemBinding.changePercentageTextview.setTextColor(
                itemBinding.root.resources.getColor(
                    R.color.gain_green
                )
            )
            itemBinding.changePercentageTextview.text =
                "+ ${itemBinding.changePercentageTextview.text}"
        }

        if (winLossPercentage == 0.0)
            itemBinding.changePercentageTextview.setTextColor(itemBinding.root.resources.getColor(R.color.black))

        itemBinding.balanceBreakdownTextview.text =
            "${item.numberOfCoins} x ${String.format("%.2f", item.rate)}"
        itemBinding.totalBalanceTextview.text =
            "$ ${String.format("%.2f", item.numberOfCoins * item.rate)}"
    }
}
