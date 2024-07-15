package com.example.pirategame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.pirategame.ui.theme.PirateGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PirateGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BasicPirateGame()
                }
            }
        }
    }
}

@Composable
fun BasicPirateGame(){

    var treasuresFound by remember {mutableStateOf(0)}
    var travelDirection by remember { mutableStateOf("North")}
    var action by remember { mutableStateOf("")}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Pirate Game",
            style = TextStyle(
                fontSize = 10.em,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "Travel Direction : $travelDirection",
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold
            ))

        Text(text = "Treasures Found : $treasuresFound",
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold))

        Text(text = "Action : $action",
            style = TextStyle(
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold))

        Spacer(modifier = Modifier.size(176.dp))
        //North movement
        Button(onClick = {
            travelDirection = "North"
            if (Random.nextBoolean()){
                treasuresFound +=1
                action = "Treasure Found!"
            }else{
                action = "Storm Ahead! Lost Treasures"
            }
        },
            modifier = Modifier.size(width = 90.dp, height = 130.dp)) {
            Text(text = "North")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            //West movement
            Button(onClick = {
                travelDirection = "West"
                if (Random.nextBoolean()){
                    treasuresFound +=1
                    action = "Treasure Found!"
                }else{
                    action = "Storm Ahead! Lost Treasures"
                }
            },
                modifier = Modifier.size(width = 150.dp, height = 90.dp)) {
                Text(text = "West")
            }

            Spacer(modifier = Modifier.width(8.dp))
            //East
            Button(onClick = {
                travelDirection = "East"
                if (Random.nextBoolean()){
                    treasuresFound +=1
                    action = "Treasure Found!"
                }else{
                    action = "Storm Ahead! Lost Treasures"
                }
            },
                modifier = Modifier.size(width = 150.dp, height = 90.dp)) {
                Text(text = "East")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        //South
        Button(onClick = {
            travelDirection = "South"
            if (Random.nextBoolean()){
                treasuresFound +=1
                action = "Treasure Found!"
            }else{
                action = "Storm Ahead! Lost Treasures"
            }
        },
            modifier = Modifier.size(width = 90.dp, height = 130.dp)) {
            Text(text = "South")
        }
    Spacer(modifier = Modifier.height(48.dp))

    FloatingActionButton(onClick = {
        treasuresFound = 0
        action = ""
    },
        modifier = Modifier.size(width= 72.dp,height = 64.dp)) {
        Text(text = "Reset")
    }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicPirateGamePreview() {
    BasicPirateGame()
}