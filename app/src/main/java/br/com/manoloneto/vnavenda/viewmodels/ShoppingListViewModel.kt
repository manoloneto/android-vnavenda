package br.com.manoloneto.vnavenda.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import br.com.manoloneto.vnavenda.data.dao.ShoppingItemDao
import br.com.manoloneto.vnavenda.data.entities.ShoppingItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val shoppingItemDao: ShoppingItemDao
) : ViewModel() {

    val shoppingItems: LiveData<List<ShoppingItem>> = shoppingItemDao.getAllItems().asLiveData()

    fun addItem(item: ShoppingItem) {
        viewModelScope.launch {
            shoppingItemDao.insertItem(item)
        }
    }

    fun updateItem(item: ShoppingItem) {
        viewModelScope.launch {
            shoppingItemDao.updateItem(item)
        }
    }

    fun removeItem(item: ShoppingItem) {
        viewModelScope.launch {
            shoppingItemDao.deleteItem(item)
        }
    }
}
