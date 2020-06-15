package id.aflah.cabaca.ui.genre

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import kotlinx.android.synthetic.main.genre_fragment.*
import javax.inject.Inject

class GenreFragment : Fragment(), GenresAdapter.GenresCallback, BooksAdapter.BookAdapterCallback {

    @Inject lateinit var viewModel: GenreViewModel
    lateinit var genreAdapter: GenresAdapter
    lateinit var booksAdapter: BooksAdapter

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

        genreAdapter = GenresAdapter(this)
        booksAdapter = BooksAdapter(this)

        rv_genres.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rv_genres.adapter = genreAdapter

        rv_books_category.layoutManager = GridLayoutManager(context, 2)
        rv_books_category.adapter = booksAdapter

        viewModel.genresLiveData.observe(viewLifecycleOwner, Observer {
            genreAdapter.addItems(it.resource)
        })

        viewModel.booksLiveData.observe(viewLifecycleOwner, Observer {
            booksAdapter.addItems(it.result)
        })
    }

    override fun onGenreClicked(idGenre: Int) {
        viewModel.getBooksByCategory(idGenre)
    }

    override fun onBookClicked(idBook: Int) {
        findNavController().navigate(GenreFragmentDirections.actionGenreFragmentToDetailBookFragment(idBook))
    }

}