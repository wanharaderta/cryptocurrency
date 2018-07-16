package com.kat.cryptocurrency

import android.support.multidex.MultiDexApplication
import com.google.firebase.auth.FirebaseAuth
import com.kat.cryptocurrency.deps.component.CoinComponent
import com.kat.cryptocurrency.deps.component.DaggerCoinComponent
import com.kat.cryptocurrency.deps.provider.CoinProvider
import com.kat.news.deps.module.NetworkModule
import com.kat.news.deps.module.ServiceModule

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 7/16/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
class CoinApps : MultiDexApplication(),CoinProvider {

    private lateinit var component: CoinComponent

    private var mAuth: FirebaseAuth? = null

    override fun onCreate() {
        super.onCreate()
        mAuth = FirebaseAuth.getInstance()


        component = DaggerCoinComponent.builder()
                .networkModule(NetworkModule(this))
                .serviceModule(ServiceModule())
                .build()
    }

    override fun providesCoinComponent(): CoinComponent = component


}