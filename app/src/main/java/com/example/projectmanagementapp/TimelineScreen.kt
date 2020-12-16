package com.example.projectmanagementapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.projectmanagementapp.ui.typography
import dev.chrisbanes.accompanist.coil.CoilImage


@Composable
fun TimelineScreen(project: Project = mockProject) {
    Column {
        Column(Modifier.padding(horizontal = 20.dp, vertical = 16.dp)) {
            Text(project.title, style = typography.h1)
            Row {
                Text(text = "${project.days} days", style = typography.body2)
                Text(
                    text = "|",
                    modifier = Modifier.padding(horizontal = 4.dp),
                    style = typography.body2
                )
                Text(text = project.date, style = typography.body2)
            }

            AvatarList(users = project.users)
        }
        Column(
            Modifier
                .background(Color(0xFFF1F5FE), shape = RoundedCornerShape(topLeft = 40.dp))
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "Hello world")

        }
    }
}

/** Custom modifier for avatar layout offset
 *
 * */
private fun Modifier.layoutOffset(x: Dp = 0.dp, y: Dp = 0.dp) =
    this then layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width + x.toIntPx(), placeable.height + y.toIntPx()) {
            placeable.placeRelative(x.toIntPx(), y.toIntPx())

        }
    }

@Composable
fun AvatarList(users: List<User>) {
    Row {
        users.forEachIndexed { index, user ->
            Avatar(
                user,
                modifier = Modifier
                    /** By using custom layoutOffset modifier, size of items that are drawn on screen are same as actual items that are shown
                     * whereas if we use modifier.offset(x = if(index > 0) -30.dp * index else 0.dp, items drawn will not calculate the minus offset */
//                    .offset(x = if (index > 0) -30.dp * index else 0.dp)
                    .layoutOffset(if (index == 0) 0.dp else -10.dp)


            )
        }
    }
}

@Composable
fun Avatar(user: User, modifier: Modifier = Modifier) {
    CoilImage(
        user.imageUrlForSize(with(AmbientDensity.current) { 40.dp.toIntPx() }),
        modifier = modifier
            .shadow(5.dp, CircleShape, clip = false)
            .background(Color.White, CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .size(48.dp)
    )
}









