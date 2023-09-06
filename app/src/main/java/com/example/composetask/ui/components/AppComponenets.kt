package com.example.composetask.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composetask.R

@Composable
fun ButtonComponent(value: String, modifier: Modifier,onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        colors =ButtonDefaults.buttonColors(colorResource(id = R.color.button_color)),
        modifier = modifier,
        contentPadding = PaddingValues(),

        ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBAR() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.movies_screen),
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp)
            )
        },
        actions = {
            Image(
                modifier = Modifier
                    .padding(end = 16.dp),
                painter = painterResource(id = R.drawable.ic_premium), contentDescription = ""
            )

        },


        modifier = Modifier
            .fillMaxWidth(),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun Header(text:String,modifier : Modifier, navHostController: NavHostController) {
    Row(
        modifier = modifier
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(end = 16.dp)
                .clickable {
                    navHostController.popBackStack()
                },
            painter = painterResource(id = R.drawable.ic_back), contentDescription = ""
        )

        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 15.dp)
        )
    }
}
