package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_gridlayout_kotlin.MovieModel
import com.example.recyclerview_gridlayout_kotlin.R

class MovieListGridRecyclerAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfMovies = listOf<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_grid_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as MovieListViewHolder
        movieViewHolder.bind(listOfMovies[position])
    }

    fun setMovieList(listOfMovies: List<MovieModel>) {
        this.listOfMovies = listOfMovies
        notifyDataSetChanged()
    }
}