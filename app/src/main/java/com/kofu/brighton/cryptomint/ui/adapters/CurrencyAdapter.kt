package com.kofu.brighton.cryptomint.ui.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kofu.brighton.cryptomint.R
import com.kofu.brighton.cryptomint.data.entities.Currency
import com.kofu.brighton.cryptomint.data.room.entities.CryptoCurrency
import com.kofu.brighton.cryptomint.databinding.CurrencyListItemBinding
import com.kofu.brighton.cryptomint.utils.CurrencyAnalysis

class CurrencyAdapter(private val clickListener: (id: Int) -> Unit) :
    ListAdapter<CryptoCurrency, CurrencyViewHolder>(CURRENCY_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemBinding =
            CurrencyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.bind(currency)
        holder.itemView.setOnClickListener {clickListener(currency.id)
                    }
    }

    companion object {
        val CURRENCY_COMPARATOR = object : DiffUtil.ItemCallback<CryptoCurrency>() {
            override fun areItemsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency): Boolean {
                return oldItem::class == newItem::class
            }

            override fun areContentsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency): Boolean {
                return (oldItem.id == newItem.id &&
                        TextUtils.equals(oldItem.name, newItem.name) &&
                        oldItem.price== newItem.price &&
                        oldItem.numberOfCoins== newItem.numberOfCoins)
            }
        }
    }
}

class CurrencyViewHolder(private val itemBinding: CurrencyListItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: CryptoCurrency) {

//        CurrencyAnalysis.calculate(item)

//        itemBinding.iconImageView.load(item.iconURL)
        itemBinding.cNameTextview.text = item.name

        itemBinding.changePercentageTextview.text = "${String.format("%.2f", CurrencyAnalysis.winLossPercentage)} %"
        if (item.percentChange < 0)
            itemBinding.changePercentageTextview.setTextColor(itemBinding.root.resources.getColor(R.color.loss_red))

        if (item.percentChange > 0) {
            itemBinding.changePercentageTextview.setTextColor(
                itemBinding.root.resources.getColor(
                    R.color.gain_green
                )
            )
            itemBinding.changePercentageTextview.text =
                "+ ${itemBinding.changePercentageTextview.text}"
        }

        if (item.percentChange == 0.0)
            itemBinding.changePercentageTextview.setTextColor(itemBinding.root.resources.getColor(R.color.black))

        itemBinding.balanceBreakdownTextview.text =
            "${item.numberOfCoins} x ${String.format("%.2f", item.price)}"
        itemBinding.totalBalanceTextview.text =
            "$ ${String.format("%.2f", item.price * item.numberOfCoins)}"
    }
}
