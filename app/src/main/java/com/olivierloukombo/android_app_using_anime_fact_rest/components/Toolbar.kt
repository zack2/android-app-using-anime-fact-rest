package com.olivierloukombo.android_app_using_anime_fact_rest.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.olivierloukombo.android_app_using_anime_fact_rest.R


@Composable
fun Toolbar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        title = {
            Text(
                text = stringResource(R.string.list_anime),
                color = Color.White,
                style = MaterialTheme.typography.h1,

                )
        }
    )
}

@Composable
fun ToolbarDetail(navController: NavHostController) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        title = {
            Text(
                text = stringResource(R.string.detail_anime),
                color = Color.White,
                style = MaterialTheme.typography.h1,

                )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        }
    )
}

@Composable
fun ToolbarDetailPrev() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                style = MaterialTheme.typography.h1,

                )
        },
        navigationIcon = {
            IconButton(onClick = {
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
            }
        }
    )
}

@Preview
@Composable
fun ToolbarPreview() {
    ToolbarDetailPrev()
}