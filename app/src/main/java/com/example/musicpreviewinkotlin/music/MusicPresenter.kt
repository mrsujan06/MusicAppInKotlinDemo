package com.example.musicpreviewinkotlin.music

import android.util.Log
import com.example.musicpreviewinkotlin.model.service.interactor.MusicApiInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MusicPresenter @Inject constructor(private var musicInteractor: MusicApiInteractor) {

    private var view: MusicView? = null
    private lateinit var subscribe: Disposable

    fun bind(view: MusicView) {
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun getMusic() {
        subscribe = musicInteractor.getMusic()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    view?.OnFetchDataSuccess(it.results)
                },
                {
                    Log.d("errorInPresenter ->", "Error While Fetching data. ${it.localizedMessage}")
                })
    }

    fun dispose() {
        subscribe.dispose()
    }

}