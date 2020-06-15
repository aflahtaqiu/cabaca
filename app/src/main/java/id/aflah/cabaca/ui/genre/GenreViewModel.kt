package id.aflah.cabaca.ui.genre

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

class GenreViewModel @Inject constructor(private val repository: CabacaRemoteRepository) : ViewModel() {

    var genresLiveData: MutableLiveData<ResponseGenre> = MutableLiveData<ResponseGenre>()
    var booksLiveData: MutableLiveData<ResponseBooks> = MutableLiveData<ResponseBooks>()

    fun getGenres () {
        viewModelScope.launch {
            when(val result = repository.getGenres().value) {
                is DataResponse.Success<ResponseGenre> -> {
                    genresLiveData.value = result.data
                }
                is DataResponse.Error -> {
                    Log.e("lkele error getgenres", result.message)
                }
            }
        }
    }

    fun getBooksByCategory (idCategory: Int) {
        viewModelScope.launch {
            when(val result = repository.getBooksByCategory(idCategory).value) {
                is DataResponse.Success<ResponseBooks> -> {
                    booksLiveData.value = result.data
                }
                is DataResponse.Error -> {
                    Log.e("lkele error getgenres", result.message)
                }
            }
        }
    }
}