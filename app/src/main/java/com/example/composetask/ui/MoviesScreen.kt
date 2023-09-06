package com.example.composetask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.composetask.R
import com.example.composetask.model.Movie
import com.example.composetask.ui.components.ButtonComponent
import com.example.composetask.ui.components.Header
import com.example.composetask.ui.components.TopAppBAR
import com.example.composetask.viewmodel.MainViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(viewModel: MainViewModel, navController: NavHostController) {
    data class Movie(var name: String, var id: Int)

    var itemList = ArrayList<Movie>()

    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))
    itemList.add(Movie("SpoiderMan", R.drawable.ic_image))


    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {

            TopAppBAR()
            Header("MOVIES", modifier = Modifier, navController)
            Spacer(
                modifier = Modifier
                    .padding(12.dp)
            )

            LazyVerticalGrid(
                modifier = Modifier
                    .wrapContentSize(),
                columns = GridCells.Fixed(3)
            ) {
                items(itemList) {
                    MovieRow(it.name, it.id) {
                        navController.navigate("detail_screen")
                    }
                }
            }
        }
        ButtonComponent(
            value = "NEXT", modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp)
        ) {
            navController.navigate("detail_screen")

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