package id.aflah.cabaca.ui.newbook

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.aflah.cabaca.data.CabacaRemoteRepository
import id.aflah.cabaca.model.DataResponse
import id.aflah.cabaca.model.ResponseGenre
import id.aflah.cabaca.model.response.ResponseBooks
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewBookViewModel @Inject constructor(private val repository: CabacaRemoteRepository) : ViewModel() {
    var booksLiveData : MutableLiveData<ResponseBooks> = MutableLiveData<ResponseBooks>()

    fun getNewBooks () {
        viewModelScope.launch {
            when(val result = repository.getNewBooks(10).value) {
                is DataResponse.Success<ResponseBooks> -> {
                    booksLiveData.value = result.data
                }
                is DataResponse.Error -> {
                    Log.e("lkele error getnewbooks", result.message)
                }
            }
        }
    }
}