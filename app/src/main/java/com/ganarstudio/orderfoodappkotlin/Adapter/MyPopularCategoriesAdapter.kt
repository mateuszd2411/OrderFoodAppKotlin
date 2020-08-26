package com.ganarstudio.orderfoodappkotlin.Adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel
import com.ganarstudio.orderfoodappkotlin.R
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_popular_categories_item.view.*

class MyPopularCategoriesAdapter (internal var context:Context,
                                  internal var popularCategoryModels: List<PopularCategoryModel>) :
            RecyclerView.Adapter<MyPopularCategoriesAdapter.MyViewHolder>() {

    inner class MyViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){

        @BindView(R.id.txt_category_name)
        var txt_category_name:TextView ?= null
        @BindView(R.id.category_image)
        var category_image: CircleImageView? = null

        var unbinder:Unbinder
        init {
            unbinder = ButterKnife.bind(this, itemView)
        }

    }
}

