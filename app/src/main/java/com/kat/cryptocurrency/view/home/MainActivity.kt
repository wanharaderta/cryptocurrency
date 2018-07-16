package com.kat.cryptocurrency.view.home

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kat.cryptocurrency.R
import com.kat.cryptocurrency.data.local.Coin
import com.kat.cryptocurrency.data.remote.RemoteCoin
import com.kat.cryptocurrency.deps.provider.CoinProvider
import com.kat.cryptocurrency.service.CoinService
import com.kat.cryptocurrency.view.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    protected lateinit var service: CoinService

    private var presenter: MainPresenter? = null

    var adapter: MainAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as CoinProvider).providesCoinComponent().inject(this)

        fun initView(){

            supportActionBar?.title = "Home"

            val layoutManager = LinearLayoutManager(this)
            rvCoin.layoutManager = layoutManager
            rvCoin.addOnScrollListener(object : RecyclerView.OnScrollListener(){

                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (dy > 0){

                        var last:Int = layoutManager.findLastVisibleItemPosition()

                        if (last == adapter!!.itemCount - 1) {
                            onProgress()
                            adapter?.coinMore()

                            val handler = Handler()
                            handler.postDelayed({
                                adapter!!.notifyDataSetChanged()
                                hide()
                            }, 3000)
                        }
                    }
                }
            })
        }

        initView()
    }

    override fun onResume() {
        presenter = MainPresenter()
        onAttach()
        super.onResume()
    }

    override fun onAttach() {
        presenter?.onAttach(this)
        presenter?.getCoin(service,10)
    }

    override fun onProgress() {
        progress_dialog.visibility = android.view.View.VISIBLE
    }

    override fun onSuccess(response: RemoteCoin) {

        val data  = response.data.map {
                val id = it?.value.id
                val name= it?.value.name
                val symbol= it.value.symbol
                val rank= it.value.rank
                val circulatingSupply= it.value.circulatingSupply
                val totalSupply= it?.value.totalSupply
                val maxSupply= it?.value.maxSupply
                val price=it?.value.quotes?.uSD?.price
                val volume24h =it?.value.quotes?.uSD?.volume24h
                val marketCap=it?.value.quotes?.uSD?.marketCap
                val percentChange1h=it?.value.quotes?.uSD?.percentChange1h
                val percentChange24h=it?.value.quotes?.uSD?.percentChange24h
                val percentChange7d=it?.value.quotes?.uSD?.percentChange7d
                val lastUpdated=it?.value.lastUpdated

            Coin(id,name,symbol,rank,circulatingSupply,totalSupply,maxSupply,
                    price,volume24h,marketCap,percentChange1h,percentChange24h,percentChange7d,lastUpdated)
        }

        adapter = MainAdapter(this,data, object : MainListener{
            override fun onClick(coin: Coin) {
                presenter?.coinDetail(coin)
            }
        })

        rvCoin.adapter = adapter
        adapter!!.notifyDataSetChanged()



        hide()
    }

    fun hide(){
        progress_dialog.visibility = android.view.View.GONE
        rvCoin.visibility = android.view.View.VISIBLE
    }

    override fun onDetach() {
        presenter?.onDetach()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }


    override fun onOpenCoinDetail(coin: Coin) {
        startActivity<DetailActivity>(
                "coin" to coin
        )
    }


}
