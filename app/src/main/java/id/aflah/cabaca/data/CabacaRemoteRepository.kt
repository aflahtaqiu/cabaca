package id.aflah.cabaca.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.aflah.cabaca.data.ApiEndpoint
import id.aflah.cabaca.model.DataResponse
import id.aflah.cabaca.model.ResponseGenre
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
}