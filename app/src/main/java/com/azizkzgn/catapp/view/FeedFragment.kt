package com.azizkzgn.catapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azizkzgn.catapp.R
import com.azizkzgn.catapp.adapter.CatAdapter
import com.azizkzgn.catapp.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val catAdapter = CatAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()


        recycler_view.layoutManager =LinearLayoutManager(context)
        recycler_view.adapter = catAdapter

        observeData()
    }

    private fun observeData(){
        viewModel.cats.observe(viewLifecycleOwner,Observer { cats->
            cats?.let {
                print("deneme")
                catAdapter.updateCatList(cats)
            }
        })
    }


}