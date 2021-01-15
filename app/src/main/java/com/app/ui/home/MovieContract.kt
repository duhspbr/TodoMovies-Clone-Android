package com.app.ui.home

import com.app.base.BasePresenter
import com.app.base.BaseView
import com.app.data.models.moviedetails.Movie
import com.app.data.models.similar.Similar

interface MovieContract {
    /**
     * Activity precisa implementar os métodos definidos abaixo
     */
    interface View : BaseView<SimilarMoviesPresenter> {
        fun setupHeader(movie: Movie?)
        fun setupRecycleSimilarMovies(similar: Similar?)
        fun displayLoading(isLoading: Boolean)
        fun displayError(msg: String)
    }

    /**
     * Presenter precisa implementar os seguintes métodos
     */
    interface Presenter : BasePresenter {
        fun loadSimilar()
        fun loadMovies()
    }
}

