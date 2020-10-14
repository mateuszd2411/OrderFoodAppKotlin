package com.ganarstudio.orderfoodappkotlin.ui.fooddetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ganarstudio.orderfoodappkotlin.Callback.ICommentCallBack
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel
import com.ganarstudio.orderfoodappkotlin.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.EnumSet.of
import java.util.List.of

class CommentFragment : BottomSheetDialogFragment(), ICommentCallBack {

    private  var commentViewModel: CommentViewModel ?= null

    private var listener: ICommentCallBack

    init {
        listener = this
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_comment_fragment, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onCommentLoadSuccess(commentList: List<CommentModel>) {

    }

    override fun onCommentLoadFailed(message: String) {

    }


}