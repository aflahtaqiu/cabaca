package id.aflah.cabaca.ui.newbook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.ItemNewBookBinding
import id.aflah.cabaca.model.Book

class NewBooksAdapter constructor(private val listener: NewBookAdapterCallback) : RecyclerView.Adapter<NewBooksAdapter.NewBooksViewHolder>() {

    inner class NewBooksViewHolder (val binding:ItemNewBookBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (item : Book) = binding.apply {
            book = item
        }
    }

    private val  items : MutableList<Book> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewBooksViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemNewBookBinding>(inflater, R.layout.item_new_book, parent, false)
        return NewBooksViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: NewBooksViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            listener.onItemClicked(item.id)
        }
    }

    fun addItems (books: List<Book>) {
        if (items.isNotEmpty())
            items.clear()
        items.addAll(books)
        notifyDataSetChanged()
    }

    interface NewBookAdapterCallback{
        fun onItemClicked(idBook: Int)
    }
}