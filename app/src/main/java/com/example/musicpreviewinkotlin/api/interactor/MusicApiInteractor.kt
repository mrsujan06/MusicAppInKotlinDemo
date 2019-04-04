package com.example.musicpreviewinkotlin.api.interactor

import com.example.musicpreviewinkotlin.model.MusicResponse
import io.reactivex.Observable

interface MusicApiInteractor {
    fun getMusic(): Observable<MusicResponse>
}