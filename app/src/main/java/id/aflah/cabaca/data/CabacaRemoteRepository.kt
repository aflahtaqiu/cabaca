package id.aflah.cabaca.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.aflah.cabaca.model.DataResponse
import id.aflah.cabaca.model.ResponseGenre
import id.aflah.cabaca.model.response.ResponseBooks
import id.aflah.cabaca.model.response.ResponseDetailBook
import id.aflah.cabaca.model.response.ResponseDetailWriter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CabacaRemoteRepository @Inject constructor(private val apiEndpoint: ApiEndpoint) {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    suspend fun getGenres():LiveData<DataResponse<ResponseGenre>> {
        val liveData = MutableLiveData<DataResponse<ResponseGenre>>()
        withContext(ioDispatcher) {
            try {
                val successResponse = apiEndpoint.getGenres()
                liveData.postValue(DataResponse.Success(successResponse))
            } catch (e:Exception) {
                liveData.postValue(DataResponse.Error(e.localizedMessage))
            }
        }
        return  liveData
    }

    suspend fun getBooksByCategory(idCategory: Int) :LiveData<DataResponse<ResponseBooks>> {
        val liveData = MutableLiveData<DataResponse<ResponseBooks>>()
        withContext(ioDispatcher) {
            try {
                val successResponse = apiEndpoint.getBooksByCategory(idCategory)
                liveData.postValue(DataResponse.Success(successResponse))
            } catch (e:Exception) {
                liveData.postValue(DataResponse.Error(e.localizedMessage))
            }
        }
        return  liveData
    }

    suspend fun getNewBooks(limit:Int?) :LiveData<DataResponse<ResponseBooks>> {
        val liveData = MutableLiveData<DataResponse<ResponseBooks>>()
        withContext(ioDispatcher) {
            try {
                val successResponse = apiEndpoint.getNewBooks(limit)
                liveData.postValue(DataResponse.Success(successResponse))
            } catch (e:Exception) {
                liveData.postValue(DataResponse.Error(e.localizedMessage))
            }
        }
        return  liveData
    }

    suspend fun getDetailBook(idBook:Int) :LiveData<DataResponse<ResponseDetailBook>> {
        val liveData = MutableLiveData<DataResponse<ResponseDetailBook>>()
        withContext(ioDispatcher) {
            try {
                val successResponse = apiEndpoint.getDetailBook(idBook)
                liveData.postValue(DataResponse.Success(successResponse))
            } catch (e:Exception) {
                liveData.postValue(DataResponse.Error(e.localizedMessage))
            }
        }
        return  liveData
    }

    suspend fun getDetailWriter(idUser:Int) :LiveData<DataResponse<ResponseDetailWriter>> {
        val liveData = MutableLiveData<DataResponse<ResponseDetailWriter>>()
        withContext(ioDispatcher) {
            try {
                val successResponse = apiEndpoint.getDetailWriter(idUser)
                liveData.postValue(DataResponse.Success(successResponse))
            } catch (e:Exception) {
                liveData.postValue(DataResponse.Error(e.localizedMessage))
            }
        }
        return  liveData
    }
}