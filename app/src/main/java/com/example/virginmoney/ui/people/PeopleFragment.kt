package com.example.virginmoney.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleModel
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {
    private lateinit var viewModel: PeopleViewModel
    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[PeopleViewModel::class.java]
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)

        viewModel.people.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getPeople()

        return binding.root
    }

    private fun setupUI(people: ArrayList<PeopleModelItemModel>){
        val peopleAdapter = PeopleAdapter(people as ArrayList<PeopleModelItemModel>?)
        binding.rvPeople.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = peopleAdapter
        }
        peopleAdapter.onItemClick = {
            val bundle = Bundle().apply {
                putSerializable("PeopleItem", it)
            }
            findNavController().navigate(
                R.id.action_nav_people_to_nav_peopleDetail, bundle
            )
        }

    }
}