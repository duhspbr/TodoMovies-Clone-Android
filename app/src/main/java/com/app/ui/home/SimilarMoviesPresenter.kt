package com.app.ui.home

import com.app.data.remote.repository.MoveRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SimilarMoviesPresenter(private val view: MovieContract.View) : MovieContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun loadSimilar() {
        view.displayLoading(true)
        compositeDisposable.add(MoveRepository.getSimilar().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayLoading(false)
                    view.setupRecycleSimilarMovies(it)
                    loadMovies()
                }) { onError ->
                    run {
                        view.displayLoading(false)
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun loadMovies() {
        view.displayLoading(true)
        compositeDisposable.add(MoveRepository.getMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.displayLoading(false)
                    view.setupHeader(it)
                }) { onError ->
                    run {
                        view.displayLoading(false)
                        view.displayError(onError.message.toString())
                    }
                })
    }

    override fun start() {
        view.bindViews()
    }

}