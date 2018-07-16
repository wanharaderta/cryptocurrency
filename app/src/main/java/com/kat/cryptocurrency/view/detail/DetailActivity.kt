package com.kat.cryptocurrency.view.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.MenuItem
import com.kat.cryptocurrency.R
import com.kat.cryptocurrency.data.local.Coin
import com.kat.cryptocurrency.deps.provider.CoinProvider
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

    private var presenter: DetailPresenter? = null
    private var coin: Coin? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        (application as CoinProvider).providesCoinComponent().inject(this)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)


        fun initView() {
            coin = intent.getParcelableExtra("coin")
            supportActionBar?.title = coin?.name.toString()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        initView()

    }

    override fun onResume() {
        presenter = DetailPresenter()
        onAttach()
        super.onResume()

    }

    override fun onAttach() {
        presenter?.onAttach(this)
        coin?.let { presenter?.setDetail(it) }
    }

    override fun onDetail(name: String?, rank: Int?, circulatingSupply: Long?,
                          totalSupply: Long, maxSupply: Long, price: Double?,
                          volume24h: Double?, marketCap: Long?, percentChange1h: Double?,
                          percentChange24h: Double?, percentChange7d: Double?, lastUpdated: Int?) {


        vRank.text = rank.toString()
        vPrice.text = price.toString()
        circulating_supply_text.text = circulatingSupply.toString()
        total_supply_text.text = totalSupply.toString()
        max_supply_text.text = maxSupply.toString()
        volume_24h_text.text = volume24h.toString()
        market_cap_text.text = marketCap.toString()
        percent_change_1h_text.text = percentChange1h.toString()
        percent_change_24h_text.text = percentChange24h.toString()
        percent_change_7d_text.text = percentChange7d.toString()
        percent_change_7d_text.text = percentChange7d.toString()
        dateTime.text = lastUpdated.toString()

    }


    override fun onDetach() {
        presenter?.onDetach()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
