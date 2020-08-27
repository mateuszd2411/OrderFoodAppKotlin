package com.ganarstudio.orderfoodappkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.asksira.loopingviewpager.LoopingPagerAdapter
import com.bumptech.glide.Glide
import com.ganarstudio.orderfoodappkotlin.Model.BestDealModel
import com.ganarstudio.orderfoodappkotlin.R

class MyBestDealsAdapter(context: Context,
                         itemList: List<BestDealModel>,
                         isInfinite: Boolean): LoopingPagerAdapter<BestDealModel>(context, itemList, isInfinite) {
    override fun inflateView(viewType: Int, container: ViewGroup, listPosition: Int): View {
        return LayoutInflater.from(context)
            .inflate(R.layout.layout_best_deal_item, container!!, false)
    }

    override fun bindView(convertView: View, listPosition: Int, viewType: Int) {
        val imageView = convertView!!.findViewById<ImageView>(R.id.img_best_deal)
        val textView = convertView!!.findViewById<TextView>(R.id.txt_best_deal)
        //set data
        Glide.with(context).load(itemList?.get(listPosition)?.image).into(imageView)
        textView.text = itemList?.get(listPosition)!!.name
    }

}