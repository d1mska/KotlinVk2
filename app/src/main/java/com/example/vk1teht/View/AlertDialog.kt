package com.example.vk1teht.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vk1teht.Model.Task
import com.example.vk1teht.viewmodel.TaskViewModel

@Composable
fun DetailDialog(viewModel: TaskViewModel = viewModel(), task: Task, onClose: () -> Unit, onUpdate: (Task) -> Unit){
    var title by remember { mutableStateOf(task.title) }
    var description by remember { mutableStateOf(task.description) }


        AlertDialog(
            onDismissRequest = onClose,
            title = {
                Text(text = "Edit task")
            },
            text = {
                Column{
                    TextField(value = title, onValueChange = {title = it})
                    TextField(value = description, onValueChange = {description = it})
                }
            },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = {
                        viewModel.deleteTask(task.id)
                        onClose()
                    }) {
                        Text(text = "Delete")
                    }
                    Button(
                        onClick = {
                            onUpdate(task.copy(title = title, description = description))
                        }
                    ) {
                        Text("save")
                    }
                }
            }
        )
    }

