package com.example.androidstudy_music.ui.home

import androidx.lifecycle.ViewModel
import com.example.androidstudy_music.data.music.MusicRepository
import com.example.androidstudy_music.data.music.PlayList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
) :ViewModel(){
    fun fetchPlayLists(): List<PlayList> = musicRepository.fetchPlayList()
}