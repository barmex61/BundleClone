package com.fatih.bundleclone.ui

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.fatih.bundleclone.R
import com.fatih.bundleclone.adapter.HomeFragmentNewsAdapter
import com.fatih.bundleclone.databinding.FragmentHomeBinding
import com.fatih.bundleclone.entities.local.News

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=DataBindingUtil.bind(view)!!
        binding.marqueText.isSelected=true
        val newList= listOf<News>(
            News("https://cdn.pixabay.com/photo/2015/10/01/17/17/car-967387_960_720.png","BITCOIN",
            "Santiment : Küçük Bitcoin Adresleri ","1 Saat")
        ,       News("https://a.fsdn.com/sd/topics/bitcoin_64.png","BITCOIN",
                "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı" +
                        " Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı","1 Saat")
        ,       News("https://cdn.webrazzi.com/uploads/2023/02/apple-468.png","BITCOIN",
                "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı" +
                        " Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı","1 Saat")
        ,       News("https://assets.entrepreneur.com/content/3x2/2000/1675180545-GettyImages-1390011916.jpg","BITCOIN",
                "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı" +
                        "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı","1 Saat")
        ,       News("https://blog.bitfinex.com/wp-content/uploads/2023/01/BFX_Salvador_new-law1-1024x576.png","BITCOIN",
                "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı" +
                        " Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı","1 Saat")
        ,       News("https://a.fsdn.com/sd/topics/crime_64.png","BITCOIN",
                "Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı" +
                        " Santiment : Küçük Bitcoin Adresleri Yeniden Canlanıyor! Boğaya Hazırlık Mı Başladı","1 Saat")
        )

        val adapter=HomeFragmentNewsAdapter()
        adapter.newsList=newList
        binding.homeFragmentRview.layoutManager=StaggeredGridLayoutManager(2,VERTICAL)
        binding.homeFragmentRview.adapter=adapter
        binding.menuImageView.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START,true)
        }
    }
}