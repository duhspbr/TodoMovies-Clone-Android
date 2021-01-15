package com.app.data.remote.datasource

import com.app.data.remote.RetrofitHelper
import com.app.data.remote.services.MovieService

object SimilarRemoteDataSource {

    private val service = RetrofitHelper.createCall(MovieService::class.java)

    fun getMovies() = service.searchMovie()

    fun getSimilar() = service.searchSimilar()

}