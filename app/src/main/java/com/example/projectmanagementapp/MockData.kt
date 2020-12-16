package com.example.projectmanagementapp

enum class Status {
    New,
    InProgress,
    Done
}

class Project(
    val id: Int,
    val title: String,
    val date: String,
    val days: Int,
    val status: Status,
    val users: List<User>,
    val tasks: List<Task>
)

class Task(
    val id: Int,
    val timeCode: String,
    val title: String,
    val tag: String,
    val status: Status,
    val assignees: List<User>,
    val commentCount: Int,
    val attachmentCount: Int,
)

class User(
    val id: Int,
    val name: String
) {
    fun imageUrlForSize(size: Int) = "https://i.pravatar.cc/$size?img=$id"
}

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
    status = Status.InProgress,
    users = listOf(zachary, sarah, mary),
    tasks = listOf(
        Task(
            id = 164,
            timeCode = "24.19",
            title = "Contact page",
            tag = "#Design",
            assignees = listOf(zachary),
            commentCount = 3,
            status = Status.InProgress,
            attachmentCount = 5
        ),
        Task(
            id = 321,
            timeCode = "23.19",

            title = "Calculator page",
            tag = "#Design",
            assignees = listOf(sarah, mary),
            commentCount = 3,
            status = Status.New,

            attachmentCount = 10
        ),
        Task(
            id = 432,
            title = "Technical task",
            tag = "#Design",
            status = Status.Done,
            timeCode = "24.19",
            assignees = listOf(zachary),
            commentCount = 3,
            attachmentCount = 6
        ),
        Task(
            id = 132,
            title = "Calculator task",
            tag = "#Backend",
            status = Status.Done,
            timeCode = "24.19",
            assignees = listOf(mary, zachary),
            commentCount = 3,
            attachmentCount = 6
        ),
        Task(
            id = 164,
            timeCode = "24.19",
            title = "Contact page",
            tag = "#Design",
            assignees = listOf(zachary),
            commentCount = 3,
            status = Status.InProgress,
            attachmentCount = 5
        ),
        Task(
            id = 321,
            timeCode = "23.19",

            title = "Calculator page",
            tag = "#Design",
            assignees = listOf(sarah, mary),
            commentCount = 3,
            status = Status.New,

            attachmentCount = 10
        ),
        Task(
            id = 432,
            title = "Technical task",
            tag = "#Design",
            status = Status.Done,
            timeCode = "21.19",
            assignees = listOf(zachary),
            commentCount = 3,
            attachmentCount = 6
        ),
        Task(
            id = 132,
            title = "Calculator task",
            tag = "#Backend",
            status = Status.Done,
            timeCode = "22.19",
            assignees = listOf(mary, zachary),
            commentCount = 3,
            attachmentCount = 6
        )
    )
)