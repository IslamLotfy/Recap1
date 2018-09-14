package com.example.islam.recap1

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {
    private var disposable: Disposable? = null

    private val theMovieDBService by lazy {
        TheMovieDBService.create()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.fragment_main, container, false)

        disposable=theMovieDBService.getCollectionOfMovies("e20080ab8b395f936423b819c9b6b689","popularity.desc")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            view.images_recycler_view.adapter=ImageRecyclerViewAdapter(result)                        },
                        { error -> Toast.makeText(activity, error.message, Toast.LENGTH_SHORT).show()
                        })

        view.images_recycler_view.layoutManager= GridLayoutManager(activity,2)
        return  view
    }

}


//how to hide api key in gradle
//kotlin object notaion
//extension function in kotlin
//@Get
//architecture component -> view model // live data
//MVP

