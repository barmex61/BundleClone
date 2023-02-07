package com.fatih.bundleclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fatih.bundleclone.R
import com.fatih.bundleclone.databinding.HomeRecyclerRowBinding
import com.fatih.bundleclone.entities.local.News

class HomeFragmentNewsAdapter:RecyclerView.Adapter<HomeFragmentNewsAdapter.HomeFragmentViewHolder>() {

    private val diffUtil=object:DiffUtil.ItemCallback<News>(){
        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem==newItem
        }

        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.image==newItem.image
        }
    }

    private val asyncListDiffer=AsyncListDiffer(this,diffUtil)

    var newsList:List<News>
        get() = asyncListDiffer.currentList
        set(value) = asyncListDiffer.submitList(value)

    class HomeFragmentViewHolder(val binding:HomeRecyclerRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewHolder {
        val binding=DataBindingUtil.inflate<HomeRecyclerRowBinding>(LayoutInflater.from(parent.context),
            R.layout.home_recycler_row,parent,false)
        return HomeFragmentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: HomeFragmentViewHolder, position: Int) {
        val new=newsList[position]
        holder.binding.homeFragmentRowContent.text=new.content
        holder.binding.homeFragmentRowTime.text=new.time
        holder.binding.homeFragmentRowTitle.text=new.title
        Glide.with(holder.itemView.context).load(new.image).into(holder.binding.homeFragmentRowImg)
    }
}