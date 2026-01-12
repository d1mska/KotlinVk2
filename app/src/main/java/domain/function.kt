package domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vk1teht.ui.theme.Vk1tehtTheme
import kotlin.Int
import kotlin.String

fun addTask(tasks: List<Task>): List<Task> {
    val newTask= Task(
        id = tasks.size + 1,
        title = "Uusi tehtävä",
        description = "kovakoodattu",
        priority = 1,
        dueDate = "1-1-2030",
        done = false
    )
    return tasks + newTask

}

fun toggleDone(tasks: List<Task>, taskId: Int): List<Task> {
    return tasks.map { task ->
        if (task.id == taskId) {
            task.copy(done = !task.done)
        } else {
            task
        }
    }
}

fun filterByDone(tasks: List<Task>): List<Task> {
    return tasks.filter{it.done}
}


fun sortByDueDate(tasks: List<Task>):List<Task> {
    return tasks.sortedBy { it.dueDate }

}


@Composable
fun HomeScreen() {
    var tasks by remember { mutableStateOf(mockData) }
    var showOnlyDone by remember { mutableStateOf(false) }

    val visibleTasks = if (showOnlyDone) {
        filterByDone(tasks)
    } else {
        tasks
    }
    Scaffold(
        bottomBar = { BottomAppBar(

        ) {
            Row(

                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier= Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    tasks = addTask(tasks)
                }) {
                    Text(text = "Add",
                        fontSize = 13.sp
                    )
                }

                Button(onClick = {
                    showOnlyDone = !showOnlyDone
                }) {
                    Text(text = "Filter Done",
                        fontSize = 13.sp
                    )
                }
                Button(onClick = {
                    tasks = sortByDueDate(tasks)
                }) {
                    Text(text = "Sort Due Date")
                }
            }
        }
        }
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top=60.dp, start = 15.dp, bottom = 15.dp, end = 15.dp)

        ) {

            LazyColumn {

                items(visibleTasks) { task ->
                    Text(if (task.done)"${task.title} | ${task.dueDate} Done" else "${task.title} | ${task.dueDate} | Do" )


                    Button(onClick ={//
                        tasks = toggleDone(tasks, task.id)


                    }) {
                        Text(if (task.done) "Undo" else "Done")
                    }
                }

            }
        }
    }

}
