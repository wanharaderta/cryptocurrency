package com.kat.news.view.base

/**
 *
 * Created by Wanhar Aderta Daeng Maro on 5/18/2018.
 * Email : wanhardaengmaro@gmail.com
 *
 */
interface Presenter<in T : View> {

    fun onAttach(view: T)

    fun onDetach()
}