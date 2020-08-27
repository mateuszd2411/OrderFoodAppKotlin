package com.ganarstudio.orderfoodappkotlin.Callback

import com.ganarstudio.orderfoodappkotlin.Model.BestDealModel
import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel

interface IBestDealLoadCallback {
    fun onBestDealLoadSuccess(bestDealList: List<BestDealModel>)
    fun onBestDealLoadFailed(message:String)
}