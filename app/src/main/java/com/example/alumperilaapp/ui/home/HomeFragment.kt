package com.example.alumperilaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home), HomeONasAdapter.HomeONasClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val vm: HomeViewModel by viewModels()
    //private val homeAdapter = HomeAdapter()
    private val homePerilAdapter = HomePerilaAdapter()
    private val homeONasAdapter = HomeONasAdapter(this)

    private val imageList = arrayListOf<SlideModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        imageList.add(SlideModel((R.drawable.image1), "Описание перил 1"))
        imageList.add(SlideModel((R.drawable.image2), "Описание перил 2"))
        imageList.add(SlideModel((R.drawable.image3), "Описание перил 3"))
        imageList.add(SlideModel((R.drawable.image4), "Описание перил 4"))
        imageList.add(SlideModel((R.drawable.image5), "Описание перил 5"))

        val sliderLayout = binding.root.findViewById<ImageSlider>(R.id.image_slider)
        sliderLayout.setImageList(imageList)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vm.getHomePerilaLiveData().observe(viewLifecycleOwner) {
            homePerilAdapter.updateHomePerilaList(it)
        }
        vm.getHomeONasLiveData().observe(viewLifecycleOwner) {
            homeONasAdapter.updateHomeONasList(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            //rcImgPerila.adapter = homeAdapter
            //rcImgPerila.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            //rcImgPerila.setItemViewCacheSize(20)

            rcPerila.adapter = homePerilAdapter
            rcPerila.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rcPerila.setItemViewCacheSize(20)

            rcONas.adapter = homeONasAdapter
            rcONas.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rcONas.setItemViewCacheSize(20)
        }
    }

    override fun onClick(command: Int) {
        findNavController().navigate(R.id.action_navigation_home_to_navigation_podrobnee)
    }
}