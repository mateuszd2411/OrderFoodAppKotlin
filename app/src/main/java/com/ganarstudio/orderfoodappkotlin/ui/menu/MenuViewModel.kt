package com.ganarstudio.orderfoodappkotlin.ui.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganarstudio.orderfoodappkotlin.Callback.ICategoryCallbackListener
import com.ganarstudio.orderfoodappkotlin.Model.BestDealModel
import com.ganarstudio.orderfoodappkotlin.Model.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MenuViewModel : ViewModel(), ICategoryCallbackListener {

    override fun onCategoryLoadSuccess(categoriesList: List<CategoryModel>) {
        categoriesListMutable!!.value = categoriesList
    }

    override fun onCategoryLoadFailed(message: String) {
        messageError.value = message
    }

    private var categoriesListMutable: MutableLiveData<List<CategoryModel>>? = null
    private var messageError: MutableLiveData<String> = MutableLiveData()
    private val categoryCallBackListener: ICategoryCallbackListener

    init {
        categoryCallBackListener = this
    }

    fun getCategoryList(): MutableLiveData<List<CategoryModel>> {
        if (categoriesListMutable == null) {
            categoriesListMutable = MutableLiveData()
            loadCategory()
        }
        return  categoriesListMutable!!
    }

    fun getMessageError(): MutableLiveData<String> {
        return messageError
    }

    private fun loadCategory() {
        val tempList = ArrayList<CategoryModel>()
        val categoryRef = FirebaseDatabase.getInstance()
            .getReference(com.ganarstudio.orderfoodappkotlin.Common.Common.CATEGORY_REF)
        categoryRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                categoryCallBackListener.onCategoryLoadFailed((error.message!!))
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (itemSnapshot in snapshot!!.children) {
                    val model =
                        itemSnapshot.getValue<CategoryModel>(CategoryModel::class.java)
                    tempList.add(model!!)
                }
                categoryCallBackListener.onCategoryLoadSuccess(tempList)
            }

        })
    }

}