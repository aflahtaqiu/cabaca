package id.aflah.cabaca.ui.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.aflah.cabaca.R
import id.aflah.cabaca.databinding.ItemGenreBinding
import id.aflah.cabaca.model.Genres

class GenresAdapter(private val listener: GenresCallback) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    inner class GenresViewHolder( val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: Genres) = binding.apply {
            genre = item
        }
    }

    private val items: MutableList<Genres> = mutableListOf()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemGenreBinding>(inflater, R.layout.item_genre, parent, false)
        return GenresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)

        holder.itemView.setOnClickListener {
            listener.onGenreClicked(item.id)
        }
    }

    fun addItems (genres: List<Genres>) {
        if (items.isNotEmpty())
            items.clear()
        items.addAll(genres)
        notifyDataSetChanged()
    }

    interface GenresCallback {
        fun onGenreClicked(idGenre: Int)
    }
}