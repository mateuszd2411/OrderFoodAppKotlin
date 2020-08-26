package com.ganarstudio.orderfoodappkotlin.Callback

import com.ganarstudio.orderfoodappkotlin.Model.PopularCategoryModel

interface IPopularLoadCallback {
    fun onPopularLoadSuccess(popularModelList: List<PopularCategoryModel>)
    fun onPopularLoadFailed(message:String)
}