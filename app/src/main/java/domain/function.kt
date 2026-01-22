package domain

import android.R.id.checkbox
import android.graphics.Color.blue
import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vk1teht.ui.theme.Vk1tehtTheme
import com.example.vk1teht.viewmodel.TaskViewModel
import kotlin.Int
import kotlin.String



@Composable
fun HomeScreen(viewModel: TaskViewModel = viewModel()) {

    val visibleTasks = if (viewModel.showOnlyDone) {
        viewModel.filterByDone(viewModel.tasks)
    } else {
        viewModel.tasks
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Column {

                    Row(

                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {


                        Button(onClick = {
                            viewModel.showOnlyDone = !viewModel.showOnlyDone
                        }) {
                            Text(
                                text = "Filter Done",
                                fontSize = 13.sp
                            )
                        }
                        Button(onClick = {
                            viewModel.tasks = viewModel.sortByDueDate(viewModel.tasks)
                        }) {
                            Text(text = "Sort Due Date")
                        }

                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)


        ) {

                OutlinedTextField(
                    value = viewModel.newTask,
                    onValueChange = { viewModel.newTask = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("New task") }
                )

                Button(
                    onClick = {
                        viewModel.addTask(viewModel.newTask)
                        viewModel.newTask = ""
                    }) {
                    Text("Add")
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 15.dp,
                    end = 15.dp,
                    bottom = 15.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)

            ) {

                items(visibleTasks) { task ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Red),
                            verticalAlignment = Alignment.CenterVertically



                    ) {

                        Checkbox(
                            checked = task.done,
                            onCheckedChange = {
                                viewModel.tasks = viewModel.toggleDone(viewModel.tasks, task.id)
                            }
                        )
                        Text("${task.title} | ${task.dueDate}",
                            modifier = Modifier
                                .weight(1f),



                        )

                        Button(onClick = {
                            viewModel.tasks = viewModel.deleteTask(viewModel.tasks, task.id)
                        }) {
                            Text(text = "Delete")
                        }
                    }
                }


            }

        }

    }
}