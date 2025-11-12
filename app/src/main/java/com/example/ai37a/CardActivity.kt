package com.example.ai37a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.ui.theme.AI37ATheme
import com.example.ai37a.ui.theme.Green

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardBody()
        }
    }
}

@Composable
fun CardBody() {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Green)
                .padding(padding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(R.drawable.apple),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                )
            }

            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    "Card", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        color = Color.White
                    )
                )
                Text(
                    "Simple and easy to use app", style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Text"
                )
                Spacer(modifier = Modifier.width(20.dp))
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Address"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Text"
                )
                Spacer(modifier = Modifier.width(20.dp))
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Address"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Text"
                )
                Spacer(modifier = Modifier.width(20.dp))
                EachCard(
                    modifier = Modifier
                        .height(200.dp)
                        .weight(1f),
                    R.drawable.apple,
                    "Address"
                )
            }
        }
    }
}

@Composable
fun EachCard(modifier: Modifier,draawable:Int,label: String) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults
            .cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(draawable),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "${label}", style = TextStyle(
                    fontSize = 20.sp
                )
            )

        }
    }
}


@Preview
@Composable
fun PreviewCard() {
    CardBody()
}