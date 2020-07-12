package callback

import com.example.recyclerview_gridlayout_kotlin.MovieModel

//Interface to manage RecyclerView Clicks
interface RecyclerViewCallback {
    fun onRecycleViewItemClick(movieModel: MovieModel, position: Int)
    fun onRecycleViewLongPress(movieModel: MovieModel, position: Int)
}