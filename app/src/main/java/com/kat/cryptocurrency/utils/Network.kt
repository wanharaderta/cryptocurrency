package com.kat.news.utils

import android.support.annotation.IntDef

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
@Retention(AnnotationRetention.SOURCE)
@IntDef(
        Network.MAX_IDLE_CONNECTIONS.toInt(),
        Network.KEEP_ALIVE_DURATION.toInt(),
        Network.CACHE_SIZE.toInt()
)
annotation class Networks

object Network {
    const val MAX_IDLE_CONNECTIONS = 15L
    const val KEEP_ALIVE_DURATION = 30L * 1000L
    const val CACHE_SIZE = 30L * 1024L * 1024L
}