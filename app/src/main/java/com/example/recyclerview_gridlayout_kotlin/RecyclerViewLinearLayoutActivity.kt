package com.example.recyclerview_gridlayout_kotlin

import adapter.MovieListAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import base.BaseActivity
import callback.RecyclerViewCallback
import kotlinx.android.synthetic.main.activity_main.*
import recyclerview_helper.DividerItemDecoration
import recyclerview_helper.VerticalSpaceItemDecoration

class RecyclerViewLinearLayoutActivity : BaseActivity(), RecyclerViewCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        recyclerViewMovies.layoutManager = LinearLayoutManager(this)
        recyclerViewMovies.addItemDecoration(VerticalSpaceItemDecoration(48))

        //This will for default android divider
        recyclerViewMovies.addItemDecoration(DividerItemDecoration(this))

        //This will for custom divider
        //recyclerViewMovies.addItemDecoration(DividerItemDecoration(this, R.drawable.drawable_divider_view))
        val movieListAdapter = MovieListAdapter().apply {
            //            itemClick = { movieTitle ->
//                Toast.makeText(this@RecyclerViewLinearLayoutActivity, movieTitle, Toast.LENGTH_SHORT).show()
//            }
//            onItemLongPress = {movieModel ->
//                Toast.makeText(this@RecyclerViewLinearLayoutActivity, movieModel.movieId.toString(), Toast.LENGTH_SHORT).show()
//            }
        }
        recyclerViewMovies.adapter = movieListAdapter
        movieListAdapter.setOnCallbackListener(this)
        movieListAdapter.setMovieList(generateDummyData())
    }

    private fun generateDummyData(): List<MovieModel> {
        val listOfMovie = mutableListOf<MovieModel>()

        var movieModel = MovieModel(1, "Avengers", 500, "16 Feb 2018", R.drawable.ic_avengers)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(2, "Avengers: Age of Ultron", 400, "17 March 2018", R.drawable.ic_avengers_2)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(3, "Iron Man 3", 550, "17 April 2018", R.drawable.ic_ironman_3)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(4, "Avengers: Infinity War", 1500, "15 Jan 2018", R.drawable.ic_avenger_five)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(5, "Thor: Ragnarok", 200, "17 March 2018", R.drawable.ic_thor)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(6, "Black Panther", 250, "17 May 2018", R.drawable.ic_panther)
        listOfMovie.add(movieModel)

        movieModel = MovieModel(7, "Logan", 320, "17 Dec 2018", R.drawable.ic_logan)
        listOfMovie.add(movieModel)

        return listOfMovie
    }

    override fun onRecycleViewItemClick(movieModel: MovieModel, position: Int) {
        Toast.makeText(this@RecyclerViewLinearLayoutActivity,
            movieModel.movieTitle + " == Position == " + position,
            Toast.LENGTH_SHORT).show()
    }

    override fun onRecycleViewLongPress(movieModel: MovieModel, position: Int) {
        Toast.makeText(this@RecyclerViewLinearLayoutActivity,
            "Movie Id =" + movieModel.movieId.toString() + " == Position == " + position,
            Toast.LENGTH_SHORT).show()
    }
}