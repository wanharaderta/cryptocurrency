package com.kat.cryptocurrency.data.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
@Parcelize
data class Coin (
        var id: Int? = 0,
        var name: String? = "",
        var symbol: String? = "",
        var rank: Int? = 0,
        var circulatingSupply: Long = 0,
        var totalSupply: Long = 0,
        var maxSupply: Long = 0,
        var price: Double? = 0.0,
        var volume24h: Double? = 0.0,
        var marketCap: Long? = 0,
        var percentChange1h: Double? = 0.0,
        var percentChange24h: Double? = 0.0,
        var percentChange7d: Double? = 0.0,
        var lastUpdated: Int? = 0) : Parcelable