package com.example.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.ItemPeopleBinding

class PeopleAdapter(val people: ArrayList<PeopleModelItemModel>?) :
    RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    var onItemClick: ((PeopleModelItemModel) -> Unit)? = null

    // ITEM/ROW all the settings/UI of individual items
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemPeopleBinding.bind(view)

        fun handleData(item: PeopleModelItemModel?) {
            binding.id.text = item?.id.toString()
            binding.firstName.text = item?.firstName.toString()

            Glide.with(itemView)
                .load(item?.avatar) // image url
                .placeholder(R.drawable.card_red) // any placeholder to load at start
                .error(R.drawable.ic_menu_gallery)  // any image in case of error
                //.override(300, 300) // resizing
                .centerCrop()
                .into(binding.avatar);
        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = people?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.handleData(people?.get(position))
        holder.itemView.setOnClickListener {
            people?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}