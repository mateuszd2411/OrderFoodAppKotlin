package com.ganarstudio.orderfoodappkotlin.EventBus

import com.ganarstudio.orderfoodappkotlin.Model.FoodModel

class FoodItemClick(var isSuccess: Boolean, var foodModel: FoodModel) {
}