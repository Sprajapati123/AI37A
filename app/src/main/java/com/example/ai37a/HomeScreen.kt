package com.example.ai37a

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(){

    data class Product(val image: Int,val label:String)

    val listData = listOf(
        Product(R.drawable.apple,"Apple"),
        Product(R.drawable.bettafish,"Fish"),
        Product(R.drawable.bird,"Bird"),
        Product(R.drawable.cat,"Cat"),
        Product(R.drawable.dog,"Dog"),
        Product(R.drawable.face,"facebook"),
    )

    LazyColumn (
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        item {
            Button(onClick = {}) {Text("Click me") }
            Button(onClick = {}) {Text("Click me") }

            LazyRow {
                items(listData.size){index->
                    Column(
                        modifier = Modifier.padding(end = 10.dp),

                    ) {
                        Image(
                            painterResource(listData[index].image),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Text(listData[index].label)
                    }
                }
            }



          }

        items(100){index->
            Text(index.toString())
        }

        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(400.dp)
            ) {
                items(listData.size){index->
                    Image(
                        painterResource(listData[index].image),
                        contentDescription = null
                    )

                }
            }
        }





    }
}