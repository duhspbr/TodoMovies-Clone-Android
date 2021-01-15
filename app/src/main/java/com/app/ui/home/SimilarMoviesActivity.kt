package com.app.ui.home

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.models.moviedetails.Movie
import com.app.data.models.similar.Similar
import com.app.utils.Constants
import com.bumptech.glide.Glide

class SimilarMoviesActivity : AppCompatActivity(), MovieContract.View {
    override lateinit var presenter: SimilarMoviesPresenter

    private val adapter by lazy {
        val adapter = SimilarAdapter()
        adapter
    }
    var headerImage: ImageView? = null
    private var btnLike: ImageView? = null
    var btnLikeTwo: ImageView? = null
    var similarList: RecyclerView? = null
    var txtTitle: TextView? = null
    var txtLikes: TextView? = null
    var txtPopularity: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = SimilarMoviesPresenter(this)
        presenter.loadSimilar()
        presenter.start()

        val btn_like = findViewById<ImageView>(R.id.src_like_btn);
        btn_like.setOnClickListener {
            btn_like.setBackgroundResource(R.drawable.ic_like_fill)
        }
    }

    override fun setupHeader(movie: Movie?) {
        if (movie != null) {
            txtTitle?.text = movie.original_title
        }
        if (movie != null) {
            txtPopularity?.text = "${movie.popularity.toString()} Assistidos"
        }
        if (movie != null) {
            txtLikes?.text = "${movie.vote_count.toString()} Curtidas"
        }

        if (movie != null) {
            headerImage?.let {
                Glide.with(this)
                        .load(Constants.URL_IMG + movie.poster_path)
                        .centerCrop()
                        .into(it)
            }

        }
    }

    override fun displayLoading(isLoading: Boolean) {

    }

    override fun displayError(msg: String) {
        Toast.makeText(this, msg,
                Toast.LENGTH_LONG).show();
    }

    override fun bindViews() {
        headerImage = findViewById(R.id.header_image)
        similarList = findViewById(R.id.similar_list)
        btnLike = findViewById(R.id.src_like_btn)
        btnLike = findViewById(R.id.src_like)
        txtTitle = findViewById(R.id.txtTitle)
        txtPopularity = findViewById(R.id.txtPopularity)
        txtLikes = findViewById(R.id.txtLikes)

        similarList?.isNestedScrollingEnabled = false

        btnLike?.setOnClickListener {
            btnLike?.setBackgroundResource(R.drawable.ic_like_fill)
        }
        btnLikeTwo?.setOnClickListener {
            btnLikeTwo?.setBackgroundResource(R.drawable.ic_like_fill)
        }
    }

    override fun setupRecycleSimilarMovies(similar: Similar?) {
        similarList?.layoutManager = LinearLayoutManager(this)
        adapter.movies = similar?.results ?: emptyList()
        similarList?.adapter = adapter
    }
}