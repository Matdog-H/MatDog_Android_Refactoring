package com.ksb.matdog_android_refactoring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.Card
import androidx.compose.ui.text.TextStyle
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("MatDog", style = TextStyle(fontSize = 30.sp))
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
                .background(Color.LightGray))

            MainColumnItem(name = "내가 본 공고")
            MainColumnItem(name = "강아지를 찾고있어요")
            MainColumnItem(name = "주인을 찾아주세요")
        }
    }
}

@Composable
fun MainColumnItem(name : String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(name, style = TextStyle(fontSize = 20.sp))
        Box(modifier = Modifier.weight(1f))
        Text("더보기")
    }

    LazyRow(){
        items(10) {
            Card(id = it)
        }
    }
}

@Composable
fun Card(id:Int){
    Card(modifier = Modifier
        .padding(5.dp)
        .border(width = 3.dp, color = Color.Black)
        .height(160.dp)
        .width(110.dp)) {
        Box(contentAlignment = Alignment.Center){
            Text(id.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}