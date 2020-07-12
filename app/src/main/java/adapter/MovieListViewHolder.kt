package adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_gridlayout_kotlin.MovieModel
import kotlinx.android.synthetic.main.list_item_grid_movie.view.*

class MovieListViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun bind(movieModel: MovieModel){
        itemView.textMovieTitle.text = movieModel.movieTitle
        itemView.textMovieViews.text = "Views: " + movieModel.movieViews
        itemView.textReleaseDate.text = "Release Date: " + movieModel.releaseDate

        Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)
    }
}