package com.app.data.models.similar

import com.app.data.models.moviedetails.Movie

data class Similar(
        var page: Int,
        var total_pages: Int,
        var total_results: Int,
        var results: List<Movie>
)