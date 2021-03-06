package id.aflah.cabaca

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingUtil {

    @JvmStatic
    @BindingAdapter("imageUrlCrop")
    fun setImageUrlCrop(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load("https://cabaca.id:8443/api/v2/files/" + url + "&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948")
            .error(R.drawable.no_image)
            .into(imageView)
    }
}