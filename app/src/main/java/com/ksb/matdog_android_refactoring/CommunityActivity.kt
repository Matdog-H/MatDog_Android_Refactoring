package com.ksb.matdog_android_refactoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



@Composable
fun CommunityScreen(function: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { MyBottomBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // FAB onClick
            }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Text("Community Activity")
    }
}
