package com.ganarstudio.orderfoodappkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.bumptech.glide.Glide
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel
import com.ganarstudio.orderfoodappkotlin.R
import de.hdodenhof.circleimageview.CircleImageView

class MyPopularCategoriesAdapter (internal var context:Context,
                                  internal var popularCategoryModels: List<PopularCategoryModel>) :
            RecyclerView.Adapter<MyPopularCategoriesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_popular_categories_item,parent,false))
    }

    override fun getItemCount(): Int {
        return popularCategoryModels.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(popularCategoryModels.get(position).image)
            .into(holder.category_image!!)
        holder.category_name!!.setText(popularCategoryModels.get(position).name)
    }

    inner class MyViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

        @BindView(R.id.txt_category_name)
        var category_name:TextView ?= null
        @BindView(R.id.category_image)
        var category_image: CircleImageView? = null

        var unbinder:Unbinder
        init {
            unbinder = ButterKnife.bind(this, itemView)
        }

    }


}

