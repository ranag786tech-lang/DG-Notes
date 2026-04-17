package com.dgnotes.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dgnotes.domain.model.Note

@Composable
fun NoteItem(
    note: Note,
    onDelete: (String) -> Unit,
    onEdit: (String, String) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 6.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(note.content, style = MaterialTheme.typography.bodyLarge)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { onDelete(note.id) }) {
                    Text("Delete")
                }
                Button(onClick = { onEdit(note.id, "${note.content} ✨") }) {
                    Text("Quick Edit")
                }
            }
        }
    }
}
