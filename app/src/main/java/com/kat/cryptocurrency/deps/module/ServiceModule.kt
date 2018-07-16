package com.kat.news.deps.module

import com.kat.cryptocurrency.data.Api
import com.kat.cryptocurrency.service.CoinService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@Module
open class ServiceModule{

    @Provides
    @Singleton
    protected fun providesCoinService(api: Api) = CoinService(api)


}