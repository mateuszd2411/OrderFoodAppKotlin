package com.ganarstudio.orderfoodappkotlin.ui.fooddetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel

class CommentViewModel : ViewModel() {

    val mutableLiveDataCommentList: MutableLiveData<List<CommentModel>>

    init {
        mutableLiveDataCommentList = MutableLiveData()
    }

    fun setCommentList(commentList: List<CommentModel>) {
        mutableLiveDataCommentList.value = commentList
    }

}