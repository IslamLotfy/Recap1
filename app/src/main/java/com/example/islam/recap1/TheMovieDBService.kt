package com.example.islam.recap1

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

// base link is : https://api.themoviedb.org/3/discover/movie?
// attributes are : api_key , sort_by
interface TheMovieDBService {
    @GET("movie")
    fun getCollectionOfMovies(@Query("api_key") apikey: String,
                              @Query("sort_by")sort_by:String):Observable<Response>

    companion object {
        fun create():TheMovieDBService{
            val retrofit =Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.themoviedb.org/3/discover/")
                    .build()
            return retrofit.create(TheMovieDBService::class.java)
        }
    }
}