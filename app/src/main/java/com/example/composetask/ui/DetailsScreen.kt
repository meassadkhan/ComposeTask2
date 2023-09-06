package com.example.composetask.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetask.ui.components.Header
import com.example.composetask.ui.components.TopAppBAR
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun DetailsScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.White
    )
    data class MovieDetails(var name: String, var id: Int, val detail:String)

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        TopAppBAR()
        Spacer(modifier = Modifier
            .padding(12.dp))
    }
    
}