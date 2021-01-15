package com.app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.R
import com.app.data.models.moviedetails.Movie
import com.app.ui.home.SimilarAdapter.RecycleViewHolder
import com.app.utils.Constants
import com.bumptech.glide.Glide
import java.util.*

class SimilarAdapter : RecyclerView.Adapter<RecycleViewHolder>() {

    var movies: List<Movie> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.items_similar, parent, false))
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        holder.title.text = movies[position].original_title
        holder.Year.text = movies[position].release_date.toString().substring(0, 4)
        //holder.type.text = movies[position].genres?.get(0).toString()
        Glide.with(holder.imgSimilar.context)
                .load(Constants.URL_IMG + movies[position].poster_path)
                .into(holder.imgSimilar)
    }

    override fun getItemCount() = movies.size

    inner class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var imgSimilar: ImageView
        var Year: TextView
        var type: TextView

        init {
            title = itemView.findViewById<View>(R.id.txtTitle) as TextView
            imgSimilar = itemView.findViewById<View>(R.id.similar_img) as ImageView
            Year = itemView.findViewById<View>(R.id.txtYear) as TextView
            type = itemView.findViewById<View>(R.id.txtType) as TextView
        }
    }

}