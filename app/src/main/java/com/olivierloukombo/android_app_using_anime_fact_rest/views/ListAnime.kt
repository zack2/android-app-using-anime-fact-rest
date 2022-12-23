package com.olivierloukombo.android_app_using_anime_fact_rest.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.olivierloukombo.android_app_using_anime_fact_rest.components.CircularProgress
import com.olivierloukombo.android_app_using_anime_fact_rest.components.Toolbar
import com.olivierloukombo.android_app_using_anime_fact_rest.model.Anime
import com.olivierloukombo.android_app_using_anime_fact_rest.navigation.Screen
import com.olivierloukombo.android_app_using_anime_fact_rest.ui.theme.AndroidappusinganimefactrestTheme
import com.olivierloukombo.android_app_using_anime_fact_rest.vm.MainViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListAnime(navController: NavHostController, viewModel: MainViewModel) {

    AndroidappusinganimefactrestTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Toolbar()
            }
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colors.background)
            ) {

                val invokedComments = viewModel.getAnimes()
                if (invokedComments.isEmpty())
                    CircularProgress()
                AnimeList(navController, invokedComments)

            }

        }


    }
}




@Composable
fun AnimeList(navController: NavHostController, animes: List<Anime>) {
    Column/*(state = rememberLazyListState())*/ {
       /* itemsIndexed(animes) { index, anime ->
            AnimePosterItem(navController, anime, index)
        }*/
      /*  items(
            items = animes,
            key = { anime ->
                anime.id
            }
        ) { anime ->
            AnimePosterItem(navController = navController, anime, 0)
        }*/

        animes.forEach {
            AnimePosterItem(navController = navController, anime = it, 0)
        }
    }
}

@Composable
fun AnimePosterItem(navController: NavHostController, anime: Anime, index: Int) {

    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.onSecondary)
            .clickable {
                navController.navigate(
                    Screen.Detail.route+"?anime=$anime"
                )
            },
        shape = RoundedCornerShape(0.dp), elevation = 4.dp
    ) {
        Surface() {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
                // horizontalArrangement = Arrangement.Center
            ) {
                AnimePic(anime.poster)
                AnimeDetail(anime = anime)
            }
        }
    }


}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AnimePic(avatarUrl: String) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.onSecondary),
        modifier = Modifier
            .size(84.dp)
            // .padding(8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
        elevation = 4.dp
    ) {
        GlideImage(
            model = avatarUrl,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(84.dp)
            // .padding(8.dp)
            // .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            ,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AnimeDetail(anime: Anime) {
    Column(
       /* verticalArrangement = Arrangement.aligned(Alignment.CenterVertically),*/
        modifier = Modifier
            .padding(6.dp)
            .fillMaxHeight()

    ) {
        Text(
            text = anime.name,
            style = MaterialTheme.typography.h1,
            maxLines = 1,
            overflow = TextOverflow.Clip

        )
        Text(
            text = anime.description,
            style = MaterialTheme.typography.h2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    AndroidappusinganimefactrestTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Toolbar()
            }
        ) {

            /* Anime(
                 1,
                 "id labore ex et quam laborum",
                 "example@example.com",
                 "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
             ).let {
                 AnimeItem(it)
             }*/
        }


    }
}