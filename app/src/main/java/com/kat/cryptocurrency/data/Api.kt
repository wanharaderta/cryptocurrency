package com.kat.cryptocurrency.data

import com.kat.cryptocurrency.data.remote.RemoteCoin
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface Api {

    @GET("ticker/")
    fun getCoin(): Flowable<RemoteCoin>
}