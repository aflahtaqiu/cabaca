package id.aflah.cabaca.ui.detailwriter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import javax.inject.Inject

class DetailWriterFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailWriterViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as CabacaApplication).component.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_writer_fragment, container, false)
    }


}