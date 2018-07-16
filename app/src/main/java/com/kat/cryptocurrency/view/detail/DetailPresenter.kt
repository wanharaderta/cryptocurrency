package com.kat.cryptocurrency.view.detail

import com.kat.cryptocurrency.data.local.Coin
import com.kat.news.view.base.Presenter

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class DetailPresenter:Presenter<DetailView>{

    private var view:DetailView? = null

    override fun onAttach(view: DetailView) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    fun setDetail(coin: Coin){

        view?.onDetail(coin.name,coin.rank,coin.circulatingSupply,
                coin.totalSupply,coin.maxSupply,coin.price,coin.volume24h
                ,coin.marketCap,coin.percentChange1h,
                coin.percentChange24h,coin.percentChange7d,coin.lastUpdated)

    }

}