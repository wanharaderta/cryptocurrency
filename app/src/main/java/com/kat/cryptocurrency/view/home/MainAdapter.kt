package com.kat.cryptocurrency.view.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kat.cryptocurrency.R
import com.kat.cryptocurrency.data.local.Coin
import kotlinx.android.synthetic.main.list_row.view.*

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class MainAdapter(
        private val context: Context,
        private val coins: List<Coin>,
        private val listener:MainListener
) : RecyclerView.Adapter<HomeHolder>() {

    companion object {
        var num = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder = HomeHolder (
            LayoutInflater.from(parent.context).inflate(
                    R.layout.list_row,
                    parent,
                    false)
    )


    fun coinMore(){
        if ((MainAdapter.num) * 10 < coins.size)
            MainAdapter.num = MainAdapter.num + 1
    }

    override fun getItemCount(): Int {
        if(MainAdapter.num *10 > coins.size){
            return coins.size
        }else{
            return MainAdapter.num *10
        }
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        val article = coins[position]
        holder.bindView(article,listener)
    }

}

class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(coin: Coin, listener: MainListener) {

        with(coin){

            itemView.txtCoin.text = coin.name
            itemView.txtCurrentPrice.text = coin.price.toString()
            itemView.txtOneHourChange.text = coin.percentChange1h.toString()
            itemView.txt24HourChange.text = coin.percentChange24h.toString()
            itemView.txt7DayChange.text = coin.percentChange7d.toString()

            itemView.setOnClickListener {
                listener.onClick(coin)
            }
        }
    }

}
