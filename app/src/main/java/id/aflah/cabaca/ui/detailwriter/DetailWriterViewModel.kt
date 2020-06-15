package id.aflah.cabaca.ui.detailwriter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.aflah.cabaca.data.CabacaRemoteRepository
import id.aflah.cabaca.model.DataResponse
import id.aflah.cabaca.model.response.ResponseDetailWriter
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailWriterViewModel @Inject constructor(private val repository: CabacaRemoteRepository)  : ViewModel() {

    var writerLiveData: MutableLiveData<ResponseDetailWriter> = MutableLiveData<ResponseDetailWriter>()

    fun getDetailWriter (idUser: Int) {
        viewModelScope.launch {
            when(val result = repository.getDetailWriter(idUser).value) {
                is DataResponse.Success<ResponseDetailWriter> -> {
                    writerLiveData.value = result.data
                }
                is DataResponse.Error -> {
                    Log.e("error getdetailwriter", result.message)
                }
            }
        }
    }
}