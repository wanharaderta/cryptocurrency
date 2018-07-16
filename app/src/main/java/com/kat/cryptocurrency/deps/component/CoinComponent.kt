package com.kat.cryptocurrency.deps.component

import com.kat.cryptocurrency.view.detail.DetailActivity
import com.kat.cryptocurrency.view.home.MainActivity
import com.kat.cryptocurrency.view.signIn.SignInActivity
import com.kat.news.deps.module.NetworkModule
import com.kat.news.deps.module.ServiceModule
import dagger.Component
import javax.inject.Singleton

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
@Singleton
@Component(modules = arrayOf( NetworkModule::class, ServiceModule::class))
interface CoinComponent{
    fun inject(mainActivity: MainActivity)
    fun inject(signInActivity: SignInActivity)
    fun inject(detailActivity: DetailActivity)


}