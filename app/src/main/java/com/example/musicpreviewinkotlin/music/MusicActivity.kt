package com.example.musicpreviewinkotlin.music

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import com.example.musicpreviewinkotlin.App
import com.example.musicpreviewinkotlin.R
import com.example.musicpreviewinkotlin.model.Result
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MusicActivity : AppCompatActivity(), MusicView {

    private lateinit var musicAdapter: MusicAdapter
    private lateinit var presenter: MusicPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).getAppComponent().inject(this)

        musicAdapter = MusicAdapter()
        initRecyclerView()

        presenter.bind(this)
        getMusic()
    }

    private fun initRecyclerView() {
        music_recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        music_recyclerview.adapter = musicAdapter
    }

    @Inject
    fun getPresenter(musicPresenter: MusicPresenter) {
        this.presenter = musicPresenter
    }
  
    private fun getMusic() {
        presenter.getMusic()
    }

    override fun onFetchDataSuccess(musicList: List<Result>) {
        musicAdapter.setMusic(musicList)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
        presenter.dispose()
    }
}
