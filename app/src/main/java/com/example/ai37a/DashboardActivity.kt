package com.example.ai37a

import SearchScreen
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ai37a.ui.theme.AI37ATheme
import com.example.ai37a.ui.theme.Blue
import com.example.ai37a.ui.theme.White

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          DashboardBody()
        }
    }
}
//mvvm with repository pattern
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardBody() {
    val context = LocalContext.current
    val activity = context as Activity

    data class NavItem(val icon:Int,val label:String)

    val listItems = listOf(
        NavItem(icon = R.drawable.baseline_home_24,label="Home"),
        NavItem(icon = R.drawable.baseline_search_24,label="Search"),
        NavItem(icon = R.drawable.baseline_notifications_24,label="Notification"),
        NavItem(icon = R.drawable.baseline_person_24,label="Profile"),
    )

    var selectedIndex by remember { mutableStateOf(0) }



//    val email = activity.intent.getStringExtra("email")
//    val password = activity.intent.getStringExtra("password")

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = White,
                    actionIconContentColor = White,
                    navigationIconContentColor = White,
                    containerColor = Blue
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text("Ecommerce")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_visibility_24),
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_more_horiz_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                listItems.forEachIndexed {index,item->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(item.label)
                        },
                        onClick = {
                            selectedIndex = index
                        },
                        selected = selectedIndex == index
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when(selectedIndex){
                0 -> HomeScreen()
                1-> SearchScreen()
                2->NotificationScreen()
                3-> ProfileScreen()
                else -> HomeScreen()
            }
//            Text("Email: $email")
//            Text("Password: $password")
        }
    }
}