package com.app.data.remote.repository

import com.app.data.remote.datasource.SimilarRemoteDataSource

object MoveRepository {
    fun getMovies() = SimilarRemoteDataSource.getMovies()
    fun getSimilar() = SimilarRemoteDataSource.getSimilar()
}