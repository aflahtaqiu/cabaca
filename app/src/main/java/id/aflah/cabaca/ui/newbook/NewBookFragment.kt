package id.aflah.cabaca.ui.newbook

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import id.aflah.cabaca.ui.genre.GenreViewModel
import javax.inject.Inject

class NewBookFragment : Fragment() {

    @Inject
    lateinit var viewModel: GenreViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as CabacaApplication).component.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_book_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}