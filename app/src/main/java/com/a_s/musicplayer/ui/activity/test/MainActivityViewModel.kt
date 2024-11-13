package com.a_s.musicplayer.ui.activity.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.Player
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//this is just a test viewmodel
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val player: Player, //just a player interface
    private val mediaResolver: MediaResolver
) : ViewModel() {

    init {
        viewModelScope.launch {
            mediaResolver()
        }
    }

    fun play() {
        player.play()
    }

    fun pause() {
        player.pause()
    }

    fun seekToNext() {
        player.seekToNext()
    }

    fun seekToPrevious() {
        player.seekToPrevious()
    }

    fun getTitle() = player.mediaMetadata.title

    fun getArtist() = player.mediaMetadata.artist

    fun getDuration() = player.duration

    fun seekTo(positionMS : Long) {
        player.seekTo(positionMS)
    }
}