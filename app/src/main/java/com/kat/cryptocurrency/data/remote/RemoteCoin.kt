package com.kat.cryptocurrency.data.remote
import com.google.gson.annotations.SerializedName


/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */


data class RemoteCoin(
    @SerializedName("data") var data : Map<Int,Data>,
    @SerializedName("metadata") var metadata: Metadata
)

data class Data(
        @SerializedName("id") var id: Int,
        @SerializedName("name") var name: String,
        @SerializedName("symbol") var symbol: String,
        @SerializedName("website_slug") var websiteSlug: String,
        @SerializedName("rank") var rank: Int,
        @SerializedName("circulating_supply") var circulatingSupply: Long,
        @SerializedName("total_supply") var totalSupply: Long,
        @SerializedName("max_supply") var maxSupply: Long,
        @SerializedName("quotes") var quotes: Quotes,
        @SerializedName("last_updated") var lastUpdated: Int
)

data class Quotes(
    @SerializedName("USD") var uSD: USD
)

data class USD(
    @SerializedName("price") var price: Double,
    @SerializedName("volume_24h") var volume24h: Double,
    @SerializedName("market_cap") var marketCap: Long,
    @SerializedName("percent_change_1h") var percentChange1h: Double,
    @SerializedName("percent_change_24h") var percentChange24h: Double,
    @SerializedName("percent_change_7d") var percentChange7d: Double
)

data class Metadata(
    @SerializedName("timestamp") var timestamp: Int,
    @SerializedName("num_cryptocurrencies") var numCryptocurrencies: Int,
    @SerializedName("error") var error: Any
)