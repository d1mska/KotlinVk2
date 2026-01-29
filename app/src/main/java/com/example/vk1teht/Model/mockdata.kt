package com.example.vk1teht.Model

import java.time.LocalDate

val mockData= listOf(
    Task(id=1, title="ostoslista", description="lista", priority = 1, dueDate = LocalDate.of(2026, 12, 12), done = true ) ,
    Task(id=2, title="työlista", description="lista", priority = 2, dueDate = LocalDate.of(2026, 2, 7), done = false ),
    Task(id=3, title="tehtävälista", description="lista", priority = 3, dueDate = LocalDate.of(2036, 2, 9), done = false ),
    Task(id=4, title="kotityöt", description="lista", priority = 4, dueDate = LocalDate.of(2027, 12, 5), done = true ),
    Task(id=5, title="remontti", description="huolto", priority = 1, dueDate = LocalDate.of(2035, 1, 1), done = false ),
    Task(id=6, title="vika", description="huomautus", priority = 1, dueDate = LocalDate.of(2026, 1, 4), done = false ),
)