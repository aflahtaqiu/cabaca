package id.aflah.cabaca.ui.detailbook

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.DetailBookFragmentBinding
import javax.inject.Inject

class DetailBookFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailBookViewModel

    lateinit var binding: DetailBookFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as CabacaApplication).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_book_fragment, container, false)
        binding.fragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailBookArgs by navArgs<DetailBookFragmentArgs>()

        viewModel.getDetailBook(detailBookArgs.idBook)

        viewModel.bookLiveData.observe(viewLifecycleOwner, Observer {
            binding.book = it.result
        })
    }

    fun onDetailWriterClicked (idWriter: Int) {
        findNavController().navigate(DetailBookFragmentDirections.actionDetailBookFragmentToDetailWriterFragment(idWriter))
    }
}