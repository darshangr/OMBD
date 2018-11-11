package com.rootminusone.omdbapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieAdapter
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieResponse
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel.InjectorUtil
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel.MovieViewModel
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel.MovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName
    var factory: MovieViewModelFactory? = null
    var viewModel: MovieViewModel? = null
    var movieItemList: RecyclerView? = null
    var movieAdapter: MovieAdapter? = null
    var textView: TextView? = null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorites -> {
                message.setText(R.string.title_favorites)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        factory = InjectorUtil.provideMovieViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, factory).get(MovieViewModel::class.java)
        textView = findViewById(R.id.message)
        movieItemList = findViewById(R.id.movielist)

        movieItemList?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        movieAdapter = MovieAdapter(arrayListOf<MovieResponse>(), this)

        movieItemList?.adapter = movieAdapter

    }


    override fun onNewIntent(intent: Intent?) {
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {

        if (Intent.ACTION_SEARCH == intent?.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
            Log.d(TAG, "Search query is :" + query)
            viewModel?.getMovieList(query)?.observe(this, Observer { movieResponse ->
                run {
                    if (movieResponse != null && !TextUtils.isEmpty(movieResponse.error)) {
                        textView?.text = movieResponse.error
                        textView?.visibility = View.VISIBLE
                    } else {
                        textView?.visibility = View.GONE
                        movieAdapter = MovieAdapter(arrayListOf(movieResponse), this)
                        movieItemList?.adapter = movieAdapter
                    }
                }
                movieAdapter?.notifyDataSetChanged()
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }
}
