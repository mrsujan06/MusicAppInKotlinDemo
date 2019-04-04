package com.example.musicpreviewinkotlin.music

import com.example.musicpreviewinkotlin.model.data.Result

interface MusicView {
    fun OnFetchDataSuccess(musicList: List<Result>)
}