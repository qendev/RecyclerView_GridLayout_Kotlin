package com.example.recyclerview_gridlayout_kotlin




import android.graphics.drawable.Drawable

data class MovieModel(var movieId: Int,
                      var movieTitle: String,
                      var movieViews: Int,
                      var releaseDate: String,
                      var moviePicture: Int?) {
    constructor() : this(0, "", 0, "", null)
}