package com.example.composetask.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.composetask.ui.components.ButtonComponent
import com.example.composetask.ui.components.Header
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
    ConstraintLayout(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(16.dp),

        ) {
        val (topBar, image, title, subtitle, description) = createRefs()

        Header(text = "DETAILS", modifier = Modifier.constrainAs(topBar) {
            top.linkTo(parent.top)
            bottom.linkTo(image.top, margin = 16.dp)
            start.linkTo(parent.start)
        }, navHostController)

        Image(
            painter = painterResource(id = R.drawable.ic_image_detail),
            contentDescription = "Feature image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(14.dp))
                .constrainAs(image) {
                    top.linkTo(topBar.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center


        )

        Text(
            text = "Name: Spider Man",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "Category: Romance",
            modifier = Modifier.constrainAs(subtitle) {
                top.linkTo(title.bottom, margin = 8.dp)
                start.linkTo(title.start)
            }
        )

        Text(
            text = "Description: A movie to kill monster  A movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monsterA movie to kill monster",
            modifier = Modifier.constrainAs(description) {
                top.linkTo(subtitle.bottom, margin = 8.dp)
                start.linkTo(title.start)
                end.linkTo(parent.end, margin = 16.dp)
                width = Dimension.preferredWrapContent
            }
        )
    }
} 
