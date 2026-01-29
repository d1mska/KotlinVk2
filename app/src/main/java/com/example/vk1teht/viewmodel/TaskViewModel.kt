package com.example.vk1teht.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.lifecycle.ViewModel
import com.example.vk1teht.Model.Task
import com.example.vk1teht.Model.mockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate

class TaskViewModel : ViewModel() {

    private val _newTask = MutableStateFlow("")
    val newTask: StateFlow<String> = _newTask.asStateFlow()


    private val _tasks = MutableStateFlow<List<Task>>(mockData)
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    var showOnlyDone by   mutableStateOf(false)

    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask
    fun onNewTaskChange(newText: String) {
        _newTask.value = newText
    }

    fun onTaskSelected(task: Task) {
        _selectedTask.value = task
    }

    fun closeDialog() {
        _selectedTask.value = null
    }

    fun updateTask(task: Task) {
        _tasks.value = _tasks.value.map { if (it.id == task.id) task else it }
        _selectedTask.value = null
    }

    fun addTask() {
        val title = _newTask.value
        if (title.isBlank()) return

        val newTask = Task(
            id = (_tasks.value.maxOfOrNull { it.id } ?: 0) + 1,
            title = title,
            description= "",
            priority = 1,
            dueDate = LocalDate.now(),
            done = false
        )

        _tasks.value = _tasks.value + newTask
        _newTask.value = ""
    }

    fun toggleDone(taskId: Int) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == taskId) task.copy(done = !task.done)
            else task
        }
    }

    fun filterByDone(tasks: List<Task>): List<Task> {
        return tasks.filter{!it.done}
    }

    fun deleteTask(taskId: Int) {
        _tasks.value = _tasks.value.filter { it.id != taskId }
    }



    fun sortByDueDate(){
        _tasks.value = _tasks.value.sortedBy { it.dueDate }

    }


}