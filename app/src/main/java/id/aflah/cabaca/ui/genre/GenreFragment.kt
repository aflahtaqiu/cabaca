package id.aflah.cabaca.ui.genre

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.ItemGenreBinding
import kotlinx.android.synthetic.main.genre_fragment.*
import javax.inject.Inject

class GenreFragment : Fragment() {

    @Inject lateinit var viewModel: GenreViewModel
    @Inject lateinit var adapter: GenresAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as CabacaApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate( R.layout.genre_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getGenres()

        rv_genres.layoutManager = GridLayoutManager(context, 2)
        rv_genres.adapter = adapter

        viewModel.genresLiveData.observe(viewLifecycleOwner, Observer {
            adapter.addItems(it.resource)
        })
    }
}