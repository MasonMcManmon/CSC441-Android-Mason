package edu.lemoyne.campusapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.lemoyne.campusapp.ui.theme.CampusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(paddingValues = innerPadding))
                }
            }
        }
    }
}
// --- Class 6 : Step one my own screen ---

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // --- Class 6 : Step 3 - a column so things stack ---
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(50.dp)
    ){
        // --- Lab 6 : Task 3 ---
        Image(
            painter = painterResource(id = R.drawable.newforandroidapp),
                contentDescription = "A Logic gate",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Class 6 : Step 4 - Real styling ---
        Text(
            text = "Club Log",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Club Events i have been to this year",
            fontSize = 16.sp,
            // --- Lab 6 : Task 1 ---
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Best Member: Mason", fontSize = 18.sp)
        Text(text = "Current Event: Website Building", fontSize = 18.sp)
        Text(text = "Next Event: Raspberry pi", fontSize = 18.sp)
        Text(text = "Future Event: NYC Trip", fontSize = 18.sp)

        // --- Lab 6 : Task 2 ---
        Spacer(modifier = Modifier.height(350.dp))

        Text(
            text = "Last Event September 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )



    }
}

@Preview
@Composable

fun HomeScreenPreview() {
    CampusAppTheme() {
            HomeScreen()
        }
}

// --- Lab 6 : Task 4 ---
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable

fun HomeScreenDarkPreview() {
    CampusAppTheme() {
        Surface {
            HomeScreen()
        }
    }
}