package id.aflah.cabaca.model

sealed class DataResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResponse<T>()
    data class Error(val message: String?, val statusCode: Int? = null) : DataResponse<Nothing>()
}