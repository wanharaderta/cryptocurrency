package com.kat.cryptocurrency.deps.provider

import com.kat.cryptocurrency.deps.component.CoinComponent

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface CoinProvider {

    fun providesCoinComponent():CoinComponent
}