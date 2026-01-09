package com.gardentracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.gardentracker.data.repository.MonthlyTasksRepository
import com.gardentracker.domain.MonthTasks
import com.gardentracker.ui.theme.GardenTrackerTheme
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GardenTrackerTheme {
                GardenTrackerApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun GardenTrackerApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    val repository = MonthlyTasksRepository()
    val currentMonth = LocalDate.now().month
    val tasks = repository.getTasksFor(currentMonth)

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Title()
                MonthlyTaskDisplay(tasks)

            }
        }
    }
}

@Composable
fun MonthlyTaskDisplay(tasks: MonthTasks) {
    Column {
        tasks.tasks.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    it
                )
                Checkbox(
                    checked = false,
                    onCheckedChange = { println("Not Implemented!") }
                )
            }
        }
        tasks.indoorPlanting.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Plant $it indoors"
                )
                Checkbox(
                    checked = false,
                    onCheckedChange = { println("Not Implemented!") }
                )
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    HOME("Home", Icons.Default.Home),
    FAVORITES("Favorites", Icons.Default.Favorite),
    PROFILE("Profile", Icons.Default.AccountBox),
}

@Composable
fun Title() {
    Text(
        text = "Garden Tracker",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GardenTrackerTheme {
    }
}