package com.dicoding.tourismapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.core.R
import com.dicoding.tourismapp.core.databinding.ItemListTourismBinding
import com.dicoding.tourismapp.core.domain.model.Restaurant
import java.util.ArrayList

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ListViewHolder>() {

  private var listData = ArrayList<Restaurant>()
  var onItemClick: ((Restaurant) -> Unit)? = null

  fun setData(newListData: List<Restaurant>?) {
    if (newListData == null) return
    listData.clear()
    listData.addAll(newListData)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false))

  override fun getItemCount() = listData.size

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val data = listData[position]
    holder.bind(data)
  }

  inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemListTourismBinding.bind(itemView)
    fun bind(data: Restaurant) {
      with(binding) {
        Glide.with(itemView.context)
          .load("https://restaurant-api.dicoding.dev/images/medium/"+data.pictureId)
          .into(ivItemImage)
        tvItemTitle.text = data.name
        tvItemSubtitle.text = data.city
      }
    }

    init {
      binding.root.setOnClickListener {
        onItemClick?.invoke(listData[adapterPosition])
      }
    }
  }
}