package com.azizkzgn.catapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.azizkzgn.catapp.R
import com.azizkzgn.catapp.model.CatModel
import com.azizkzgn.catapp.util.getImage
import com.azizkzgn.catapp.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_cat.view.*

class CatAdapter(val catList: ArrayList<CatModel>):RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    class CatViewHolder(var view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_cat,parent,false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.view.nameId.text = catList[position].name
        holder.view.catOriginId.text = catList[position].origin
        holder.view.catDescriptionId.text = catList[position].description

        holder.view.catImage.getImage(catList[position].imageId)
        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(action)

        }

    }

    override fun getItemCount(): Int {
        return catList.size
    }

    fun updateCatList(newList:List<CatModel>){
        catList.clear()
        catList.addAll(newList)
        notifyDataSetChanged()
    }
}