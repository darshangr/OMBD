package com.rootminusone.omdbapp.com.rootminusone.omdbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rootminusone.omdbapp.R
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item_list.view.*

class MovieAdapter(val items : ArrayList<MovieResponse>, val context: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) : ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_item_list, p0, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        if (items != null && items[p1] != null) {
            p0.title?.text = items[p1].title
            p0.year?.text = items[p1].year
            p0.director?.text = items[p1].director
            p0.plot?.text = items[p1].plot
//            p0?.moviepic?.setImageURI(items[p1].poster)
            Picasso.get().load(items[p1].poster).into(p0.moviepic)
        }
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val title = view.findViewById<TextView>(R.id.title)
        val year = view.findViewById<TextView>(R.id.year)
        val director = view.findViewById<TextView>(R.id.director)
        val plot = view.findViewById<TextView>(R.id.plot)
        val moviepic = view.findViewById<ImageView>(R.id.moviepic)
    }
}


