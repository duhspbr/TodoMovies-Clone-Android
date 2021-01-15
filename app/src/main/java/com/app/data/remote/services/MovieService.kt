package com.app.data.remote.services

import com.app.data.models.moviedetails.Movie
import com.app.data.models.similar.Similar
import com.app.utils.Constants
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("3/movie/" + Constants.FIXED_MOVIE + "?api_key=" + Constants.API_KEY)
    fun searchMovie(): Single<Movie?>

    @GET("3/movie/" + Constants.FIXED_MOVIE + "/similar" + "?api_key=" + Constants.API_KEY)
    fun searchSimilar(): Single<Similar?>
}