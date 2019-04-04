package com.example.musicpreviewinkotlin.dagger

import com.example.musicpreviewinkotlin.api.interactor.MusicApiInteractor
import com.example.musicpreviewinkotlin.api.interactor.MusicApiInteractorImp
import dagger.Module
import dagger.Provides

@Module
class MusicModule {

    @Provides
    fun getMusicApiInteractorImp(): MusicApiInteractor {
        return MusicApiInteractorImp()
    }
}