package com.example.musicpreviewinkotlin.dagger

import com.example.musicpreviewinkotlin.music.MusicActivity
import dagger.Component

@Component(modules = [MusicModule::class])
interface AppComponent {
    fun inject(musicActivity: MusicActivity)
}