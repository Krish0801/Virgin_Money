package com.example.virginmoney.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.data.model.rooms.RoomsModelItemModel
import com.example.virginmoney.databinding.FragmentRoomsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private lateinit var viewModel: RoomsViewModel
    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[RoomsViewModel::class.java]
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)

        viewModel.rooms.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getRooms()

        return binding.root
    }



    private fun setupUI(rooms: ArrayList<RoomsModelItemModel>){
        val roomsAdapter = RoomsAdapter(rooms as ArrayList<RoomsModelItemModel>?)
        binding.rvRooms.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = roomsAdapter
        }
        roomsAdapter.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("RoomsItem", it)
            }
//            findNavController().navigate(
//                R.id.action_assets_to_asset_details, bundle
//            )
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//         //Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }
}