package com.example.earlybuddy_pattern.ui.visited

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.earlybuddy_pattern.data.model.Place
import com.example.earlybuddy_pattern.databinding.ItemAddressBinding

class PlaceAdapter() : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    val newPlaceList = ArrayList<Place>()

    fun setListData(placeList: List<Place>) {
        with(newPlaceList) {
            clear()
            addAll(placeList)
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaceViewHolder {
        val binding: ItemAddressBinding =
            ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newPlaceList.size
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(newPlaceList[position])
    }

    class PlaceViewHolder(val binding: ItemAddressBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Place) {
            binding.place = data
        }
    }
}

