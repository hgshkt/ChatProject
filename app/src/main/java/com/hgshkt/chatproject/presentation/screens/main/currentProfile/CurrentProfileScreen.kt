package com.hgshkt.chatproject.presentation.screens.main.currentProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hgshkt.chatproject.R

@Composable
fun CurrentProfileScreen() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Background image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.fillMaxHeight(0.25f)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Background image",
            modifier = Modifier.size(80.dp)
        )
        Text("Name")
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    CurrentProfileScreen()
}