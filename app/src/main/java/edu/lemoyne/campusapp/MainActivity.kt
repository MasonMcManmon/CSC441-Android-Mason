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
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

// --- Class 7 : Step 1 : A counter that remembers ---
@Composable
fun counterDemo() {
    var count by remember { mutableStateOf(value = 0) }

    Button(
        onClick = { count++ }
    ) {
        Text(text = "Tapped $count Times")

    }
}


// --- Class 6 : Step one my own screen ---

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    // --- Class 7 : Step 2 - the list lives in state ---

    var meetings = remember {
        mutableStateListOf(
            "Past Event: Introduction",
            "Current Event: Website Building",
            "Next Event: Raspberry pi",
            "Future Event: NYC Trip"
        )
    }
    // ---Class 7 : Step 3 - What's type lives in state

    var newMeeting by remember { mutableStateOf( value = "" )}

    // --- Class 6 : Step 3 - a column so things stack ---
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(50.dp)
    ) {
        // --- Class 7 : Step 1 - A counter that remembers call ---
        //counterDemo()

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


        // --- Class 7 : Step 3 - The text Field ---
        OutlinedTextField(
            value = newMeeting,
            onValueChange = { newMeeting = it },
            label = { Text("Meeting Name")},
            modifier = Modifier.fillMaxWidth()
            )

        // --- Lab 7 : Task 4 - A live character Counter ---
        Text(
            text = "${newMeeting.length} /40",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // --- Class 7 : Step 4 - The button changes the state

        Button(onClick = {
            meetings.add(newMeeting)
            newMeeting = ""
        }){
            Text("Add Meeting")
        }
        // --- Lab 7 : Task 1 - Remove the last item ---
        Button(onClick = {
            if (meetings.isNotEmpty()){
                meetings.removeAt(meetings.lastIndex)
                //meetings.removeLast()
            }
        }){
            Text("Remove Last")

        }
        // --- Lab 7 : Task 3 - Clear all ---
        Button(onClick = {
            meetings.clear()
        }) {
            Text("Clear all")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // --- class 7 : Draw what is in list ---
        // --- Lab 7 : Task 2 - singular and plural
        Text(
            text = if (meetings.size == 1) "1 Meeting" else "${meetings.size} Meetings",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        for (meetings in meetings) {
            Text(text = meetings, fontSize = 18.sp)
        }

        // --- Lab 6 : Task 2 ---
        Spacer(modifier = Modifier.height(250.dp))

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