package com.ksb.matdog_android_refactoring

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    val scrollState = rememberScrollState()

    // Smooth scroll to specified pixels on first composition
//    LaunchedEffect(Unit) { scrollState.animateScrollTo(10000) }


    val scaffoldState = rememberScaffoldState()

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
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("MatDog", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold), modifier = Modifier.padding(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp)
                    .background(Color.White)
            ){
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = Icons.Default.Check,
                    contentDescription = "CAMERA"
                )
            }

            MainColumnItem(name = "내가 본 공고")
            MainColumnItem(name = "강아지를 찾고있어요")
            MainColumnItem(name = "주인을 찾아주세요")
            Box(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun MainColumnItem(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(name, style = TextStyle(fontSize = 20.sp))
        Box(modifier = Modifier.weight(1f))
        Text("더보기")
    }

    LazyRow() {
        items(10) {
            Card(id = it)
        }
    }
    
    Box(modifier = Modifier.height(50.dp))
}

@Composable
fun Card(id: Int) {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .border(width = 3.dp, color = Color.Black)
            .height(160.dp)
            .width(110.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(5.dp)
                .background(Color.DarkGray))
            Text(id.toString())
        }

    }
}

@Composable
fun MyBottomBar() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
        cutoutShape = CircleShape
    ) {

        bottomMenuItemsList.forEachIndexed { index, menuItem ->
            if (index == 1) {
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon = {},
                    enabled = false
                )
            }

            BottomNavigationItem(
                selected = (selectedItem == menuItem.label),
                onClick = {
                    selectedItem = menuItem.label
                    Toast.makeText(
                        contextForToast,
                        menuItem.label, Toast.LENGTH_SHORT
                    ).show()
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                enabled = true
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}