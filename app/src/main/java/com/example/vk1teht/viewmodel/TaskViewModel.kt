package com.example.vk1teht.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import domain.Task
import domain.mockData

class TaskViewModel : ViewModel() {
    var newTask by   mutableStateOf("")

    var tasks by mutableStateOf(listOf<Task>())


    var showOnlyDone by   mutableStateOf(false)


    init {
        tasks = mockData
    }

    fun addTask(title: String){
        if (title.isBlank()) return

        val newTask= Task(
            id = tasks.size + 1,
            title = title,
            description = "kovakoodattu",
            priority = 1,
            dueDate = "2027-6-18",
            done = false
        )
        tasks= tasks + newTask

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
        return tasks.filter{!it.done}
    }

    fun deleteTask(tasks: List<Task>, taskId: Int): List<Task> {
        return tasks.filter { it.id != taskId }
    }



    fun sortByDueDate(tasks: List<Task>):List<Task> {
        return tasks.sortedBy { it.dueDate }

    }
    /*
    fun NewTaskField(
        text: String,
        onValueChange: (String) -> Unit
    ){
      OutlineTextField(
        value = text,
          label = {Text("Uusi tehtävä")}
      )
    }
*/

}