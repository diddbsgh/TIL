package com.example.androidstudy_music.ui.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidstudy_music.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicSheetContent(
    onHideCurrentPlayModal: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
             TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onHideCurrentPlayModal) {
                        Icon(imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = null,
                            )
                    }
                },
                title = { Text(text = "IU") },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Outlined.MoreVert,
                            contentDescription = null
                        )
                    }
                }
            )

        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically,
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            CoverImage(
                modifier = Modifier
                    .size(350.dp)
            )
            MusicInformation(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            MusicController(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun CoverImage(
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier.clip(shape = RoundedCornerShape(12.dp)),
        painter = painterResource(id = R.drawable.image), contentDescription = null
    )
}

@Composable
fun MusicInformation(
    modifier: Modifier = Modifier
) {
    var progress by remember { mutableFloatStateOf(0f) }

    Column(modifier = modifier) {
        Text(text = "LILAC")
        Text(text = "IU")
        Slider(
            value = progress,
            onValueChange = { newValue ->
                progress = newValue
            },
        )
    }
}

@Composable
fun MusicController(
    modifier: Modifier = Modifier
) {
    var playing by remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        }
        IconButton(

            onClick = { playing = !playing }) {
            Icon(
                imageVector = if (playing) {
                    Icons.Filled.Refresh
                } else {
                    Icons.Filled.PlayArrow
                }, contentDescription = null
            )

        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null)

        }
    }
}