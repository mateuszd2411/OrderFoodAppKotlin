package com.ganarstudio.orderfoodappkotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Callback.IPopularLoadCallback
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel
import com.google.android.gms.common.internal.service.Common
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeViewModel : ViewModel(), IPopularLoadCallback {
    override fun onPopularLoadSuccess(popularModelList: List<PopularCategoryModel>) {
        popularListMutableLiveData!!.value = popularModelList
    }

    override fun onPopularLoadFailed(message: String) {
        messageError.value = message
    }

    private var popularListMutableLiveData: MutableLiveData<List<PopularCategoryModel>> ?= null
    private lateinit var messageError: MutableLiveData<String>
    private lateinit var popularLoadCallbackListener: IPopularLoadCallback

    val popularList: LiveData<List<PopularCategoryModel>>
        get() {
            if (popularListMutableLiveData == null) {
                popularListMutableLiveData = MutableLiveData()
                messageError = MutableLiveData()
                loadPopularList()
            }
            return popularListMutableLiveData!!
        }

    init {
        popularLoadCallbackListener = this
    }

    private fun loadPopularList() {
        val tempList = ArrayList<PopularCategoryModel>()
        val popularRef = FirebaseDatabase.getInstance()
            .getReference(com.ganarstudio.orderfoodappkotlin.Common.Common.POPULAR_REF)
        popularRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                popularLoadCallbackListener.onPopularLoadFailed((error.message!!))
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnapshot in snapshot!!.children) {
                    val model =
                        itemSnapshot.getValue<PopularCategoryModel>(PopularCategoryModel::class.java)
                    tempList.add(model!!)
                }
                popularLoadCallbackListener.onPopularLoadSuccess(tempList)
            }

        })
    }

}