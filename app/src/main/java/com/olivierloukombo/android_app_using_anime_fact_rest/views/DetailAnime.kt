package com.olivierloukombo.android_app_using_anime_fact_rest.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.GlideImage
import com.olivierloukombo.android_app_using_anime_fact_rest.components.ToolbarDetail
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import com.olivierloukombo.android_app_using_anime_fact_rest.ui.theme.AndroidappusinganimefactrestTheme
import com.olivierloukombo.android_app_using_anime_fact_rest.vm.DetailViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.olivierloukombo.android_app_using_anime_fact_rest.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailAnime(navController: NavHostController, viewModel: DetailViewModel) {

    AndroidappusinganimefactrestTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                ToolbarDetail(navController)
            }
        ) {

            val detailAnime = viewModel.getDetailAnime()
            if (detailAnime != null) {
                DetailPoster(detailAnime)
            }
        }
    }
}

@Composable
fun DetailPoster(anime: Anime) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        anime,
                        this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(
                        anime = anime,
                        containerHeight =  this@BoxWithConstraints.maxHeight
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun ProfileHeader(
    anime: Anime,
    containerHeight: Dp
) {
    GlideImage(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        model = anime.poster,
        contentScale = ContentScale.Crop,
        contentDescription = "Poster Anime"
    )
}

@Composable
private fun ProfileContent(anime: Anime, containerHeight: Dp) {
    Column {
        Title(anime)
        ProfileProperty(stringResource(R.string.description), anime.description)
        ProfileProperty(stringResource(R.string.play_time), anime.playtime)
        ProfileProperty(stringResource(R.string.release_date), anime.release)
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}



@Composable
private fun Title(
    anime: Anime
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)) {
        Text(
            text = anime.name,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 4.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.caption,
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.body1,
            maxLines = 2,
            overflow = TextOverflow.Visible
        )
    }
}