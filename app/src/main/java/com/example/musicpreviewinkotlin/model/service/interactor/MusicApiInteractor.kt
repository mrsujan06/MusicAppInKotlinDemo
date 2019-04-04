package com.example.musicpreviewinkotlin.model.service.interactor

import com.example.musicpreviewinkotlin.model.data.MusicResponse
import io.reactivex.Observable

interface MusicApiInteractor {
    fun getMusic(): Observable<MusicResponse>
}