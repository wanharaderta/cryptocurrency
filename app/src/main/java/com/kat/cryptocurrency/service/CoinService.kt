package com.kat.cryptocurrency.service

import com.kat.cryptocurrency.data.Api
import com.kat.cryptocurrency.data.remote.RemoteCoin
import com.kat.news.utils.disposableSubscriber
import id.kotlin.training.movies.services.NetworkCallTransformer
import id.kotlin.training.movies.services.NetworkCallback
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function


/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class CoinService(private val api: Api) {

    fun getCoin(callback: NetworkCallback<RemoteCoin>): Disposable {
        return api.getCoin()
                .compose(NetworkCallTransformer<RemoteCoin>())
                .onErrorResumeNext(Function { Flowable.error { it } })
                .subscribeWith(disposableSubscriber<RemoteCoin>(
                        next = { response -> callback.onSuccess(response) },
                        error = { exception -> callback.onError(exception) }

                ))

    }
}