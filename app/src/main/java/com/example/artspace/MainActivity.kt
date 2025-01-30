package com.example.artspace

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    MainView()
                }
            }
        }
    }


@Composable
fun MainView(modifier: Modifier = Modifier){
    data class Places(val name: String, val place: String, val year: String)
    val placesList: List<Places> = listOf(
        Places("The Bean", "Chicago, Illinois", "2024"),
        Places("Monument Circle", "Indianapolis, Indiana", "2024")
    )

    var currentIndex by remember { mutableIntStateOf(0) }


    Column(
        modifier = modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ImageCard(title = "The Bean", place = "Chicago, Illinois", year = "2024" )

        Row(
            modifier = modifier
                .padding(16.dp)
        ){
            ButtonComponent(onClick = { Log.d("boton","Back")}, iconImg = Icons.AutoMirrored.Default.ArrowBack)
            Spacer(modifier = modifier.width(32.dp))
            ButtonComponent(onClick = {Log.d("boton","Forward") }, iconImg = Icons.AutoMirrored.Default.ArrowForward)
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    title: String,
    place: String,
    year: String){
    Surface(
        modifier = modifier
            .width(350.dp)
            .padding(1.dp),
        shadowElevation = 1.dp
    ) {
        Column(modifier = modifier.padding(20.dp)) {
            Text(
                text = title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$place ($year)"
            )
        }
    }
}

@Composable
fun ButtonComponent(
    modifier: Modifier  = Modifier,
    onClick: () -> Unit,
    iconImg: ImageVector
){
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = iconImg,
            contentDescription = null
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        MainView()
    }
}