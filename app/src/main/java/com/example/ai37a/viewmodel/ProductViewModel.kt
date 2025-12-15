package com.example.ai37a.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ai37a.model.ProductModel
import com.example.ai37a.repository.ProductRepo

class ProductViewModel(val repo : ProductRepo) : ViewModel() {

    fun addProduct(model: ProductModel,callback:(Boolean,String)->Unit){
        repo.addProduct(model,callback)
    }

    fun updateProduct(model: ProductModel,callback: (Boolean, String) -> Unit){
        repo.updateProduct(model,callback)
    }

    fun deleteProduct(productID:String,callback: (Boolean, String) -> Unit){
        repo.deleteProduct(productID,callback)
    }

    private val _products = MutableLiveData<ProductModel?>()
    val products : MutableLiveData<ProductModel?> get() = _products

    private val _allProducts = MutableLiveData<List<ProductModel>?>()
    val allProducts : MutableLiveData<List<ProductModel>?> get() = _allProducts


    fun getProductById(productID:String){
        repo.getProductById(productID){
            success,msg,data->
            if(success){
                _products.postValue(data)
            }
        }
    }

    fun getAllProduct(){
        repo.getAllProduct{
                success,msg,data->
            if(success){
                _allProducts.postValue(data)
            }
        }
    }

    private val _allProductsCategory = MutableLiveData<List<ProductModel>?>()
    val allProductsCategory : MutableLiveData<List<ProductModel>?> get() = _allProductsCategory

    fun getProductByCategory(categoryId:String){
        repo.getProductByCategory(categoryId){
            success,msg,data->
            if(success){
                _allProductsCategory.postValue(data)
            }
        }
    }
}