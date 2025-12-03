package com.example.ai37a

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun NotificationScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Red)
    ) {

        Text("Notification Screen")
    }
}