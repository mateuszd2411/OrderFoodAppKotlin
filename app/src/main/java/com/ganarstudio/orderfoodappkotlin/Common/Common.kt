package com.ganarstudio.orderfoodappkotlin.Common

import com.ganarstudio.orderfoodappkotlin.Model.CategoryModel
import com.ganarstudio.orderfoodappkotlin.Model.UserModel

object Common {
    var categorySelected: CategoryModel ?= null
    val CATEGORY_REF: String = "Category"
    val FULL_WIDTH_COLUMN: Int = 1
    val DEFAULT_COLUMN_COUNT: Int = 0
    val BEST_DEALS_REF: String = "BestDeals"
    val POPULAR_REF: String = "MostPopular"
    val USER_REFERENCE = "Users"
    var currentUser:UserModel ?= null
}