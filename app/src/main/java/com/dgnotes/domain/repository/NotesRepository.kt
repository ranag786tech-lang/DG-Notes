package com.dgnotes.domain.repository

import com.dgnotes.domain.model.Note

interface NotesRepository {
    suspend fun getNotes(): List<Note>
    suspend fun addNote(content: String)
    suspend fun deleteNote(id: String)
    suspend fun updateNote(id: String, content: String)
}
