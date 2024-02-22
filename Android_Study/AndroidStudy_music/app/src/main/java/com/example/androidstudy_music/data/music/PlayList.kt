package com.example.androidstudy_music.data.music

data class PlayList(
    val id: Long,
    val title: String,
    val madeBy: String,
)

val dummyPlayList = listOf(
    PlayList(
        id = 1,
        title = "title1",
        madeBy = "asd",
    ),
    PlayList(
        id = 2,
        title = "title2",
        madeBy = "qwe",
    ),
    PlayList(
        id = 3,
        title = "title3",
        madeBy = "ert",
    ),
    PlayList(
        id = 4,
        title = "title4",
        madeBy = "cbv",
    ),
)