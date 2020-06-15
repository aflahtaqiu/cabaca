package id.aflah.cabaca.ui.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.ItemNewBookBinding
import id.aflah.cabaca.model.Book

class BooksAdapter constructor(private val listener: BookAdapterCallback) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    inner class BooksViewHolder (val binding:ItemNewBookBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (item : Book) = binding.apply {
            book = item
        }
    }

    private val  items : MutableList<Book> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemNewBookBinding>(inflater, R.layout.item_new_book, parent, false)
        return BooksViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            listener.onBookClicked(item.id)
        }
    }

    fun addItems (books: List<Book>) {
        if (items.isNotEmpty())
            items.clear()
        items.addAll(books)
        notifyDataSetChanged()
    }

    interface BookAdapterCallback{
        fun onBookClicked(idBook: Int)
    }
}