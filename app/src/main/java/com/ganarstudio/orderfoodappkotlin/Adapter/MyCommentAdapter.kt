package com.ganarstudio.orderfoodappkotlin.Adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel

class MyCommentAdapter(internal var context: Context,
                       internal var commentList: List<CommentModel>): RecyclerView.Adapter<MyCommentAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView) : RecyclerView.ViewHolder(itemView) {

    }
}