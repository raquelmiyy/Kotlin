package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        innerPadding ->
                    App(modifier = Modifier.padding(innerPadding))
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    //aqui é onde você vai colocar o conteúdo da sua tela
   App()
}

@Composable
fun App(modifier: Modifier = Modifier){
    //aqui é onde você vai colocar o conteúdo da sua tela
    val lista = List(100){ itemDaLista -> "Item - $itemDaLista"}

//        LazyColumn(modifier.fillMaxSize(),){
//            item{
//                Text(
//                    text = "Header da lista",
//                    fontSize = 24.sp
//                )
//            }
//            itemsIndexed(lista) { index, itemDaLista ->
//                if(index % 2 == 0){
//                Text(
//                    color =  Color.Red,
//                    fontSize = 24.sp,
//                    text = itemDaLista
//                )
//                }else{
//                    Text(
//                        color =  Color.Blue,
//                        fontSize = 24.sp,
//                        text = itemDaLista
//                    )
//                }
//            }
//
//            item{
//                Text(
//                    text = "Footer da lista",
//                    fontSize = 24.sp
//                )
//            }
//
//        }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize(),
    ) {
        items(lista) { item ->
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black),
                contentAlignment = Alignment.Center

            ) {
                Text(
                    text = item,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
    }



