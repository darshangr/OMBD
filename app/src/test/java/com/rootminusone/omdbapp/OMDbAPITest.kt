package com.rootminusone.omdbapp

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.util.StringUtil
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieAdapter
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.MovieRepository
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.model.MovieDatabase
import com.rootminusone.omdbapp.com.rootminusone.omdbapp.viewmodel.InjectorUtil
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class OMDbAPITest {

    val factory = InjectorUtil.provideMovieViewModelFactory(Application())
    //Databased and DAO has to be mocked for additional testing.
    val quoteRepository = MovieRepository.getInstance(MovieDatabase.getInstance(Application())?.movieDataDao())
    val lifecycle = Mockito.mock(LifecycleOwner::class.java)

    @Test
    fun testSearchSuccessResponse() {


        val resposne = quoteRepository.getMovieList("titanic")

        resposne.observe(lifecycle, Observer {
            movieResponse -> run {
            if (movieResponse != null && !TextUtils.isEmpty(movieResponse.error)) {

            } else {
                Assert.assertEquals(movieResponse.director, "James Cameron")
                Assert.assertEquals(movieResponse.director, "1997")
                //Add more cases as needed

            }
        }
         })

    }

}