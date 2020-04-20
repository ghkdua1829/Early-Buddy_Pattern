package com.example.earlybuddy_pattern.ui.visited

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.earlybuddy_pattern.R
import com.example.earlybuddy_pattern.databinding.ActivityVisitedPlaceBinding

class VisitedPlaceActivity : AppCompatActivity() {

    lateinit var placeAdapter: PlaceAdapter

    val vm: VisitedPlaceViewModel = VisitedPlaceViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityVisitedPlaceBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_visited_place)

        binding.vm = vm
        binding.lifecycleOwner = this

        placeAdapter = PlaceAdapter()
        binding.actSearchRv.adapter = placeAdapter

        binding.btnSearch.setOnClickListener {
            vm.getAddress(binding.actSearchEtSearch.text.toString())
        }

    }
}
