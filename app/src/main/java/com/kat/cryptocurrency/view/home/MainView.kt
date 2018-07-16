package com.kat.cryptocurrency.view.home

import com.kat.cryptocurrency.data.local.Coin
import com.kat.cryptocurrency.data.remote.RemoteCoin
import com.kat.news.view.base.View

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface MainView: View {

    fun onProgress()

    fun onSuccess(response: RemoteCoin)

    fun onOpenCoinDetail(coin: Coin)
}