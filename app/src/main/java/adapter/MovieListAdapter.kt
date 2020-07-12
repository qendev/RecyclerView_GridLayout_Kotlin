package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import callback.RecyclerViewCallback
import com.example.recyclerview_gridlayout_kotlin.MovieModel
import com.example.recyclerview_gridlayout_kotlin.R

class MovieListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listOfMovies = mutableListOf<MovieModel>()

    var itemClick: ((String) -> Unit)? = null
    var onItemLongPress: ((MovieModel) -> Unit)? = null

    var recyclerViewCallback: RecyclerViewCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)).apply {
//            itemClick = { movieTitle ->
//                this@MovieListAdapter.itemClick?.invoke(movieTitle)
//            }
//
//            onItemLongPress = { movieModel ->
//                this@MovieListAdapter.onItemLongPress?.invoke(movieModel)
//            }

            itemView.setOnClickListener {
                this@MovieListAdapter.recyclerViewCallback?.onRecycleViewItemClick(listOfMovies[adapterPosition], adapterPosition)
            }

            itemView.setOnLongClickListener {
                this@MovieListAdapter.recyclerViewCallback?.onRecycleViewLongPress(listOfMovies[adapterPosition], adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as MovieListViewHolder
        movieViewHolder.bind(listOfMovies[position])
    }

    fun setMovieList(listOfMovies: List<MovieModel>) {
        this.listOfMovies = listOfMovies.toMutableList()
        notifyDataSetChanged()
    }

    fun addMoreData(listOfMovies: List<MovieModel>) {
        this.listOfMovies.addAll(listOfMovies)
        notifyDataSetChanged()
    }

    fun setOnCallbackListener(recyclerViewCallback: RecyclerViewCallback) {
        this.recyclerViewCallback = recyclerViewCallback
    }

}