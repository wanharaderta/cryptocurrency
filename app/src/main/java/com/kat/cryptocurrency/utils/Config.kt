package com.kat.news.utils

import android.support.annotation.StringDef

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */

@Retention(AnnotationRetention.SOURCE)
@StringDef(
        Config.BASE_URL

)
annotation class Configs

object Config {
    const val BASE_URL = "https://api.coinmarketcap.com/v2/"

}