package com.example.composetask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.composetask.R
import com.example.composetask.model.Movie
import com.example.composetask.viewmodel.MainViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(viewModel: MainViewModel, navController: NavController) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White
    )
    val movies = remember {
        mutableStateListOf<Movie>()
    }
    LoadingBar(isLoading = movies.isEmpty())
    LaunchedEffect(key1 = true, block = {
        movies.addAll(viewModel.getMovies())
    })
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.movies_screen),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
        )

        LazyColumn(modifier = Modifier.background(color = Color.White)) {
            items(movies) { movie ->
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color.Gray.copy(alpha = 0.5f)),
                    verticalArrangement = Arrangement.Top,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            val json =
                                Moshi.Builder().build().adapter(Movie::class.java).toJson(movie)
                            navController.navigate("detail_screen") {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    "movie",
                                    json
                                )
                            }
                        }
                    ) {
                        AsyncImage(
                            model = movie.imageUrl,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(60.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop, contentDescription = null
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.padding(top = 5.dp, bottom = 8.dp)
                        ) {
                            TextFun(text = stringResource(R.string.name) + " " + movie.name)
                            TextFun(text = stringResource(R.string.category) + " " + movie.category)
                            TextFun(text = stringResource(R.string.description) + " " + movie.desc)
                        }
                    }

                }
            }
        }
    }


}

@Composable
fun TextFun(text: String) {
    Text(text = text, fontSize = 16.sp, color = Color.Black)
}

@Composable
fun LoadingBar(isLoading: Boolean) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp), color = Color.Cyan
            )
        }
    }
}
@Composable
@Preview
fun MovieScreenPreview() {
    MoviesScreen(viewModel = viewModel(), rememberNavController())
}