package com.example.sunnyweather.ui.place

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunnyweather.R
import com.example.sunnyweather.SunnyWeatherApplication
import com.example.sunnyweather.logic.network.SunnyWeatherNetWork
import kotlinx.android.synthetic.main.fragment_place.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by ygj on 2020/12/4.
 */
class SearchPlaceFragment : Fragment() {

    private lateinit var adapter: PlaceAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(SunnyWeatherApplication.application)
        ).get(PlaceSearchViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PlaceAdapter(viewModel.placeList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        viewModel.placeLiveData.observe(viewLifecycleOwner) { result ->
            val placeList = result.getOrNull()
            if (placeList.isNullOrEmpty()) {
                recyclerView.visibility = View.GONE
            } else {
                recyclerView.visibility = View.VISIBLE
                adapter.mDatas.clear()
                adapter.mDatas.addAll(placeList)
                adapter.notifyDataSetChanged()
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchPlaceEdit.addTextChangedListener { editable ->
            val searchKey = editable.toString()
            viewModel.searchPlace(searchKey)
        }


    }


}