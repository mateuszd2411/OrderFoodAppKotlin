package com.ganarstudio.orderfoodappkotlin.Callback

import com.ganarstudio.orderfoodappkotlin.Model.CategoryModel
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel

interface ICommentCallBack {
    fun onCommentLoadSuccess(commentList: List<CommentModel>)
    fun onCommentLoadFailed(message:String)
}