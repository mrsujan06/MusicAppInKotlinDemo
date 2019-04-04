package com.example.musicpreviewinkotlin.music

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.musicpreviewinkotlin.R
import com.example.musicpreviewinkotlin.model.data.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_list_layout.view.*

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.MusicAdapterViewHolder>() {

    private val music: MutableList<Result> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapterViewHolder {
        return MusicAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.music_list_layout,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return music.size
    }

    override fun onBindViewHolder(holder: MusicAdapterViewHolder, position: Int) {
        holder.bindModel(music[position])
    }

    fun setMusic(data: List<Result>) {
        music.addAll(data)
        notifyDataSetChanged()
    }

    inner class MusicAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val albumName: TextView = itemView.album_name
        private val songName: TextView = itemView.song_name
        private val artistPhoto: ImageView = itemView.artist_photo
        private var context: Context = itemView.context

        init {
            itemView.setOnClickListener(this)
        }

        fun bindModel(music: Result) {
            albumName.text = music.artistName
            songName.text = music.collectionName
            Picasso.get().load(music.artworkUrl100).into(artistPhoto)
        }

        override fun onClick(v: View?) {
            playMusic(music[adapterPosition].previewUrl)
        }

        private fun playMusic(url: String) {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setDataAndType(uri, "audio/mpeg3")
            context.startActivity(intent)
        }
    }
}
