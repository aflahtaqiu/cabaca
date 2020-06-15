package id.aflah.cabaca.ui.detailbook

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.aflah.cabaca.data.CabacaRemoteRepository
import id.aflah.cabaca.model.DataResponse
import id.aflah.cabaca.model.ResponseGenre
import id.aflah.cabaca.model.response.ResponseDetailBook
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailBookViewModel @Inject constructor(private val repository: CabacaRemoteRepository)  : ViewModel() {

    var bookLiveData: MutableLiveData<ResponseDetailBook> = MutableLiveData<ResponseDetailBook>()

    fun getDetailBook (idBook: Int) {
        viewModelScope.launch {
            when(val result = repository.getDetailBook(idBook).value) {
                is DataResponse.Success<ResponseDetailBook> -> {
                    bookLiveData.value = result.data
                }
                is DataResponse.Error -> {
                    Log.e("error getdetailbook", result.message)
                }
            }
        }
    }
}