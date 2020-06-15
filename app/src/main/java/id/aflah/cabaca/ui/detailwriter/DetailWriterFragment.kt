package id.aflah.cabaca.ui.detailwriter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import id.aflah.cabaca.CabacaApplication
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.DetailWriterFragmentBinding
import javax.inject.Inject

class DetailWriterFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailWriterViewModel

    lateinit var binding: DetailWriterFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as CabacaApplication).component.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_writer_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailWriterArgs by navArgs<DetailWriterFragmentArgs>()

        viewModel.getDetailWriter(detailWriterArgs.idWriter)
        viewModel.writerLiveData.observe(viewLifecycleOwner, Observer {
            binding.writer = it.result
        })
    }
}