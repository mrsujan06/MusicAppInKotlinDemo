package com.example.musicpreviewinkotlin.music

import com.example.musicpreviewinkotlin.model.Result

interface MusicView {
    fun onFetchDataSuccess(musicList: List<Result>)
}