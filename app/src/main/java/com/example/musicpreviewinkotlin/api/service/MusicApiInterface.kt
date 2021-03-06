package com.example.musicpreviewinkotlin.api.service

import com.example.musicpreviewinkotlin.model.MusicResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MusicApiInterface {

    @GET("search?term=pop&amp;media=music&amp;entity=song&amp;limit=50")
    fun getMusic(): Observable<MusicResponse>
}