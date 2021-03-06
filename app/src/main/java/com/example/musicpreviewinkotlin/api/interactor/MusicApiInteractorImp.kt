package com.example.musicpreviewinkotlin.api.interactor

import com.example.musicpreviewinkotlin.model.MusicResponse
import com.example.musicpreviewinkotlin.api.service.MusicApiInterface
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MusicApiInteractorImp : MusicApiInteractor {

    private val apiMusic: MusicApiInterface

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        apiMusic = retrofit.create(MusicApiInterface::class.java)
    }

    override fun getMusic(): Observable<MusicResponse> {
        return apiMusic.getMusic()
    }
}