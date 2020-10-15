package com.ganarstudio.orderfoodappkotlin.ui.fooddetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganarstudio.orderfoodappkotlin.Callback.ICommentCallBack
import com.ganarstudio.orderfoodappkotlin.Common.Common
import com.ganarstudio.orderfoodappkotlin.Model.CommentModel
import com.ganarstudio.orderfoodappkotlin.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dmax.dialog.SpotsDialog
import java.util.EnumSet.of
import java.util.List.of

class CommentFragment : BottomSheetDialogFragment(), ICommentCallBack {

    private  var commentViewModel: CommentViewModel ?= null

    private var recycyler_comment:RecyclerView?=null

    private var listener: ICommentCallBack

    private var dialog: AlertDialog? = null

    init {
        listener = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val itemView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_comment_fragment, container, false)
        initViews(itemView)
        loadCommentFromFirebase()
        return itemView
    }

    private fun loadCommentFromFirebase() {
        dialog!!.show()

        val commentModels = ArrayList<CommentModel>()
        FirebaseDatabase.getInstance().getReference(Common.COMMENT_REF)
            .child(Common.foodSelected!!.id!!)
            .orderByChild("commentTimeStamp")
            .limitToLast(100)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    listener.onCommentLoadFailed(p0.message)
                }

                override fun onDataChange(p0: DataSnapshot) {
                    for (commentSnapShot in p0.children) {
                        val  commentModel = commentSnapShot.getValue<CommentModel>(CommentModel::class.java)
                        commentModels.add(commentModel!!)
                    }
                    listener.onCommentLoadSuccess(commentModels)
                }

            })
    }

    private fun initViews(itemView: View?) {
        commentViewModel = ViewModelProviders.of(this).get(CommentViewModel::class.java)

        dialog = SpotsDialog.Builder().setContext(requireContext()).setCancelable(false).build()

        recycyler_comment = itemView!!.findViewById(R.id.recycler_comment) as RecyclerView
        recycyler_comment!!.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        recycyler_comment!!.layoutManager = layoutManager
        recycyler_comment!!.addItemDecoration(DividerItemDecoration(requireContext(), layoutManager.orientation))
    }


    override fun onCommentLoadSuccess(commentList: List<CommentModel>) {

    }

    override fun onCommentLoadFailed(message: String) {

    }


}