package com.dgnotes.domain.usecase

import com.dgnotes.domain.repository.NotesRepository

class GetNotesUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke() = repo.getNotes()
}

class AddNoteUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke(text: String) = repo.addNote(text)
}

class DeleteNoteUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke(id: String) = repo.deleteNote(id)
}

class UpdateNoteUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke(id: String, content: String) = repo.updateNote(id, content)
}
