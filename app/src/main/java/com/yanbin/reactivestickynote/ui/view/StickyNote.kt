package com.yanbin.reactivestickynote.ui.view

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.yanbin.reactivestickynote.model.Note
import com.yanbin.reactivestickynote.model.Position

@Composable
fun StickyNote(
    modifier: Modifier = Modifier,
    onPositionChanged: (Position) -> Unit = {},
    onClick: (Note) -> Unit,
    note: Note,
    selected: Boolean,
) {
    val offset by animateIntOffsetAsState(
        targetValue = IntOffset(
            note.position.x.toInt(),
            note.position.y.toInt()
        )
    )

    val highlightBorder: @Composable Modifier.(Boolean) -> Modifier = { show ->
        if (show) {
            this.border(2.dp, Color.Black, MaterialTheme.shapes.medium)
        } else {
            this
        }.padding(8.dp)
    }

    Surface(
        modifier.offset { offset }
            .size(108.dp, 108.dp)
            .highlightBorder(selected),
        color = Color(note.color.color),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .clickable { onClick(note) }
            .pointerInput(note.id) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    onPositionChanged(Position(dragAmount.x, dragAmount.y))
                }
            }
            .padding(16.dp)
        ) {
            Text(text = note.text, style = MaterialTheme.typography.h5)
        }
    }
}
