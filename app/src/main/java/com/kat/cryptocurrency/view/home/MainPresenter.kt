package com.kat.cryptocurrency.view.home

import android.util.Log
import com.kat.cryptocurrency.data.local.Coin
import com.kat.cryptocurrency.data.remote.RemoteCoin
import com.kat.cryptocurrency.service.CoinService
import com.kat.news.utils.safeDispose
import com.kat.news.view.base.Presenter
import id.kotlin.training.movies.services.NetworkCallback
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class MainPresenter: Presenter<MainView>{

    private var view: MainView? = null
    private var disposables: CompositeDisposable? = null


    override fun onAttach(view: MainView) {
        this.view = view
        disposables = CompositeDisposable()
    }

    override fun onDetach() {
        view = null
        disposables.safeDispose()
    }

    fun getCoin(service: CoinService, limit: Int) {
        view?.onProgress()

        val disposable = service.getCoin(object : NetworkCallback<RemoteCoin> {
            override fun onSuccess(response: RemoteCoin) {
                view?.onSuccess(response)

            }

            override fun onError(e: Throwable) {
                Log.e("coin",e.message, e)

            }

        })

        disposable.let { disposables?.add(it) }
    }

    fun coinDetail(coin: Coin){
        view?.onOpenCoinDetail(coin)
    }

}