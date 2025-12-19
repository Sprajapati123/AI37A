package com.example.ai37a

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ai37a.repository.ProductRepoImpl
import com.example.ai37a.ui.theme.Blue
import com.example.ai37a.ui.theme.PurpleGrey80
import com.example.ai37a.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

    LaunchedEffect(Unit) {
        productViewModel.getAllProduct()
    }

    var pName by remember { mutableStateOf("") }
    var pPrice by remember { mutableStateOf("") }
    var pDesc by remember { mutableStateOf("") }

    val allProducts = productViewModel.allProducts.observeAsState(initial = emptyList())

    var showDialog by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    },
                    confirmButton = {
                        TextButton(onClick = {}) { Text("Update") }
                    },
                    dismissButton = {
                        TextButton(onClick = {}) { Text("Cancel") }
                    },
                    title = { Text("Update Product") },
                    text = {
                        Column {
                            // 3 ota outlinedTextField
                            Spacer(modifier = Modifier.height(50.dp))
                            OutlinedTextField(
                                value = pName,
                                onValueChange = { data ->
                                    pName = data
                                },
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product name")
                                },

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            OutlinedTextField(
                                value = pPrice,
                                onValueChange = { data ->
                                    pPrice = data
                                },
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Price")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            OutlinedTextField(
                                value = pDesc,
                                onValueChange = { data ->
                                    pDesc = data
                                },
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Description")
                                },
                                maxLines = 5,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Color.Transparent
                                )

                            )
                        }
                    }
                )
            }
        }
        items(allProducts.value!!.size) { index ->
            var data = allProducts.value!![index]
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {
                Column {
                    Text(data.name)
                    Text(data.price.toString())
                    Text(data.description)
                    IconButton(onClick = {
                        showDialog = true
                    }) {
                        Icon(Icons.Default.Edit,
                            contentDescription = null) }
                    IconButton(onClick = {
                        productViewModel.deleteProduct(data.productId) { success, msg ->
                            if (success) {

                            } else {

                            }
                        }
                    }) { Icon(Icons.Default.Delete, contentDescription = null) }

                }
            }
        }
    }
}