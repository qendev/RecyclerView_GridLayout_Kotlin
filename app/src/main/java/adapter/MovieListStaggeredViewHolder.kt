package adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_gridlayout_kotlin.MovieModel
import kotlinx.android.synthetic.main.list_item_grid_movie.view.*
import java.util.*

class MovieListStaggeredViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mRandom = Random()
    fun bindView(movieModel: MovieModel) {
        itemView.textMovieTitle.text = movieModel.movieTitle
        itemView.textMovieViews.text = "Views: " + movieModel.movieViews
        itemView.textReleaseDate.text = "Release Date: " + movieModel.releaseDate
        itemView.imageMovie.layoutParams.height = getRandomIntInRange(250, 150)
        Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)
    }

    private fun getRandomIntInRange(max: Int, min: Int): Int {
        return mRandom.nextInt(max - min + min) + min
    }
}