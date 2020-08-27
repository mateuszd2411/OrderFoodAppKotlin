package com.ganarstudio.orderfoodappkotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Callback.IBestDealLoadCallback
import com.ganarstudio.orderfoodappkotlin.Callback.IPopularLoadCallback
import com.ganarstudio.orderfoodappkotlin.Model.BestDealModel
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel
import com.google.android.gms.common.internal.service.Common
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeViewModel : ViewModel(), IPopularLoadCallback, IBestDealLoadCallback {
    override fun onBestDealLoadSuccess(bestDealList: List<BestDealModel>) {
        bestDealListMutableLiveData!!.value = bestDealList
    }

    override fun onBestDealLoadFailed(message: String) {
        messageError.value = message
    }

    override fun onPopularLoadSuccess(popularModelList: List<PopularCategoryModel>) {
        popularListMutableLiveData!!.value = popularModelList
    }

    override fun onPopularLoadFailed(message: String) {
        messageError.value = message
    }

    private var popularListMutableLiveData: MutableLiveData<List<PopularCategoryModel>>? = null
    private var bestDealListMutableLiveData: MutableLiveData<List<BestDealModel>>? = null
    private lateinit var messageError: MutableLiveData<String>
    private var popularLoadCallbackListener: IPopularLoadCallback
    private var bestDealCallbackListener: IBestDealLoadCallback

    val bestDeaList: LiveData<List<BestDealModel>>
        get() {
            if (bestDealListMutableLiveData == null) {
                bestDealListMutableLiveData = MutableLiveData()
                messageError = MutableLiveData()
                loadBestDealList()
            }
            return bestDealListMutableLiveData!!
        }

    private fun loadBestDealList() {
        val tempList = ArrayList<BestDealModel>()
        val bestDealRef = FirebaseDatabase.getInstance()
            .getReference(com.ganarstudio.orderfoodappkotlin.Common.Common.BEST_DEALS_REF)
        bestDealRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                bestDealCallbackListener.onBestDealLoadFailed((error.message!!))
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnapshot in snapshot!!.children) {
                    val model =
                        itemSnapshot.getValue<BestDealModel>(BestDealModel::class.java)
                    tempList.add(model!!)
                }
                bestDealCallbackListener.onBestDealLoadSuccess(tempList)
            }

        })
    }

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
        bestDealCallbackListener = this
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