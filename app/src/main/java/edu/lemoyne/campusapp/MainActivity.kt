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

    // --- Class 8 : Step 2 - the error message lives in status too ---
    var error by remember { mutableStateOf<String?> (value = null)}

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
            // ---Class 8 : Step 3 - the field itself pushes back ---
            onValueChange = {
                newMeeting = it.take(n = MAX_NAME_LENGTH)
                error = null

                            },
            label = { Text("Meeting Name")},
            singleLine = true,
            isError = error != null,
            modifier = Modifier.fillMaxWidth()
            )

        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                fontSize = 14.sp
            )
        }

        // --- Lab 7 : Task 4 - A live character Counter ---
        Text(
            text = "${newMeeting.length} /$MAX_NAME_LENGTH",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )



        // --- Class 7 : Step 4 - The button changes the state ---

        Button(onClick = {
            // --- Class 8: Step 3 - Check before you add ---
            val problem = validateMeetingName(input = newMeeting, existingMeetings = meetings)
            if (problem == null) {
                meetings.add(newMeeting)
                newMeeting = ""
            } else {
                error = problem
            }

        },
        // --- Class 8 : Step 4 : The sign on the door, not the lock ---
            enabled = newMeeting.isNotBlank()

        ){
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
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last Event September 2026",
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )


    }
}

const val MAX_NAME_LENGTH = 40

// --- Class 8 : Step 1 - 1 rule book for meeting names ---
fun validateMeetingName (input: String, existingMeetings: List<String>): String? {
    val meetingName = input.trim()
    return when {
        meetingName.isEmpty() -> "Enter a Meeting Name: "
        // --- Lab 8 : Task 1 - minimum length ---
        meetingName.length < 3 -> "Too Short - at Least 3 characters"
        // --- Lab 8 : Task 2 - My own rule ---
        meetingName.all {it.isDigit()} -> "A meeting name can't be only numbers"
        meetingName.length > MAX_NAME_LENGTH -> "Keep it to $MAX_NAME_LENGTH Characters or fewer"
        existingMeetings.any { it.equals(other = meetingName, ignoreCase = true)} -> "$meetingName is already on the List"
        else -> null
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