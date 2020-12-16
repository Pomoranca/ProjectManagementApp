package com.example.projectmanagementapp

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

enum class ProjectStatus {
    New,
    InProgress,
    Completed
}

class Project(
    val id: Int,
    val title: String,
    val date: String,
    val days: Int,
    val status: ProjectStatus,
    val users: List<User>,
    val tasks: List<Task>
)

class Task(
val id: Int,
val title: String,
val tag: String,
val assignees: List<User>,
val commentCount: Int,
val attachmentCount: Int,
)

class User(
    val id: Int,
    val name: String
)

val zachary = User(
    id = 1,
    name = "Zachary Buttler"
)

val sarah = User(
    id = 2,
    name = "Sarah Murphy"
)
val mary = User(
    id = 3,
    name = "Mary Brown"
)

val mockProject = Project(
    id = 1,
    title = "Create additional pages",
    date = "Dec 10, 2019",
    days = 3,
    status = ProjectStatus.InProgress,
    users = listOf(zachary, sarah, mary),
    tasks = listOf(Task(
        id = 164,
        title = "Contact page",
        tag = "#Design",
        assignees = listOf(zachary),
        commentCount = 3,
        attachmentCount = 5
    ),
        Task(
            id = 321,
            title = "Calculator page",
            tag = "#Design",
            assignees = listOf(sarah, mary),
            commentCount = 3,
            attachmentCount = 10
        ),
        Task(
            id = 432,
            title = "Technical task",
            tag = "#Design",
            assignees = listOf(zachary),
            commentCount = 3,
            attachmentCount = 6
        )
    )
)

@Composable
fun TimelineScreen(project: Project = mockProject) {

    Text("This is timeline screen")


}