package com.kat.cryptocurrency.view.detail

import com.kat.news.view.base.View

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface DetailView:View {

    fun onDetail(name: String?,rank: Int?, circulatingSupply: Long?,
                 totalSupply: Long,maxSupply: Long,price: Double?,
                 volume24h: Double?,marketCap: Long?,percentChange1h: Double?,
                 percentChange24h: Double?,percentChange7d: Double?,lastUpdated: Int?)
}