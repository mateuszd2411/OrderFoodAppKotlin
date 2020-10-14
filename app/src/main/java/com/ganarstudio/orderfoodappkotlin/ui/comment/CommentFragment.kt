package com.ganarstudio.orderfoodappkotlin.ui.fooddetail

import com.ganarstudio.orderfoodappkotlin.Callback.ICommentCallBack
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CommentFragment : BottomSheetDialogFragment(), ICommentCallBack {
    override fun onCommentLoadSuccess(commentList: List<CommentModel>) {
        TODO("Not yet implemented")
    }

    override fun onCommentLoadFailed(message: String) {
        TODO("Not yet implemented")
    }


}