package com.example.composetask.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.composetask.R
import com.example.composetask.model.Movie
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(navHostController: NavHostController) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White
    )
    BackHandler {
        navHostController.popBackStack()
    }
    ConstraintLayout {
        val (topBar, image, title, subtitle, description) = createRefs()
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.movie_detail_screen),
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .constrainAs(topBar) {
                            top.linkTo(parent.top)
                            bottom.linkTo(image.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .padding(end = 15.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
        )

        Image(painter = painterResource(id = R.drawable.ic_image_detail),
            contentDescription = "Feature image",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .constrainAs(image) {
                    top.linkTo(topBar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }

        )

        Text(
            text = "365 days",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "Romance",
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 8.dp)
                start.linkTo(title.start)
            }
        )

        Text(
            text = "A movie to express love in a 365 ways",
            modifier = Modifier.constrainAs(description) {
                top.linkTo(subtitle.bottom, margin = 8.dp)
                start.linkTo(title.start)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.preferredWrapContent
            }
        )

    }
} 
