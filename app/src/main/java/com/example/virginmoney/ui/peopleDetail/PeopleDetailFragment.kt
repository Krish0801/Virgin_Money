package com.example.virginmoney.ui.peopleDetail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleModelItemModel
import com.example.virginmoney.databinding.FragmentPeopleDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailFragment : Fragment() {

    private var _binding: FragmentPeopleDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PeopleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[PeopleDetailViewModel::class.java]
        _binding = FragmentPeopleDetailBinding.inflate(inflater, container, false)

        val people = arguments?.getSerializable("PeopleItem") as PeopleModelItemModel

        binding.id.text = people.id
        binding.firstName.text = people.firstName
        binding.email.text = people.email
        binding.jobTitle.text = people.jobtitle
        binding.favouriteColor.text = people.favouriteColor

        Glide.with(requireView())
            .load(people?.avatar) // image url
            .placeholder(R.drawable.card_red) // any placeholder to load at start
            .error(R.drawable.ic_menu_gallery)  // any image in case of error
            .override(200, 200) // resizing
            .centerCrop()
            .into(binding.avatar);


        return binding.root
    }

}

