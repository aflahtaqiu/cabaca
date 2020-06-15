package id.aflah.cabaca.ui.newbook

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import id.aflah.cabaca.ui.genre.GenreViewModel
import kotlinx.android.synthetic.main.genre_fragment.*
import kotlinx.android.synthetic.main.new_book_fragment.*
import javax.inject.Inject

class NewBookFragment : Fragment(), NewBooksAdapter.NewBookAdapterCallback {

    @Inject lateinit var viewModel: NewBookViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = NewBooksAdapter(this)

        viewModel.getNewBooks()

        rv_new_books.layoutManager = GridLayoutManager(context, 2)
        rv_new_books.adapter = adapter

        viewModel.booksLiveData.observe(viewLifecycleOwner, Observer {
            adapter.addItems(it.result)
            Log.e("newbook fragment", "jumlah buku baru =  ${it.result.size}")
        })
    }

    override fun onItemClicked(idBook: Int) {
        findNavController().navigate(NewBookFragmentDirections.actionNewBookFragmentToDetailBookFragment(idBook))
    }
}