package com.example.virginmoney.ui.rooms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.DataModel
import com.example.virginmoney.data.model.rooms.RoomsModel
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import com.example.virginmoney.databinding.ItemRoomsBinding

class RoomsAdapter(val rooms: ArrayList<RoomsModelItemModel>?) :
    RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    var onItemClick: ((RoomsModelItemModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRoomsBinding.bind(view)

        fun handleData(item: RoomsModelItemModel?) {
            binding.roomsId.text = item?.id
            binding.roomsMaxOccupancy.text = item?.maxOccupancy.toString()
            binding.roomsIsOccupied.text = item?.isOccupied.toString()
        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rooms, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = rooms?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: RoomsAdapter.ViewHolder, position: Int) {
        holder.handleData(rooms?.get(position))
        holder.itemView.setOnClickListener {
            rooms?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}