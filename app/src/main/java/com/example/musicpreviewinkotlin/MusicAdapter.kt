package com.example.musicpreviewinkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

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

        val album_name: TextView = itemView.findViewById(R.id.album_name)
        val song_name: TextView = itemView.findViewById(R.id.song_name)
        val artist_photo: ImageView = itemView.findViewById(R.id.artist_photo)

        fun bindModel(music: Result) {
            album_name.text = music.artistName
            song_name.text = music.collectionName
            Picasso.get().load(music.artworkUrl100).into(artist_photo)
        }

        override fun onClick(v: View?) {
            println("Clicked")
        }
    }
}
