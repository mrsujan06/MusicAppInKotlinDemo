package com.example.musicpreviewinkotlin.music

import com.example.musicpreviewinkotlin.model.Result

interface MusicView {
    fun OnFetchDataSuccess(musicList: List<Result>)
}