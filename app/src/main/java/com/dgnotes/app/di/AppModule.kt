package com.dgnotes.app.di

import com.dgnotes.data.repository.NotesRepositoryImpl
import com.dgnotes.domain.repository.NotesRepository
import com.dgnotes.domain.usecase.AddNoteUseCase
import com.dgnotes.domain.usecase.DeleteNoteUseCase
import com.dgnotes.domain.usecase.GetNotesUseCase
import com.dgnotes.domain.usecase.UpdateNoteUseCase

object AppModule {
    private val notesRepository: NotesRepository by lazy { NotesRepositoryImpl() }

    val getNotesUseCase by lazy { GetNotesUseCase(notesRepository) }
    val addNoteUseCase by lazy { AddNoteUseCase(notesRepository) }
    val deleteNoteUseCase by lazy { DeleteNoteUseCase(notesRepository) }
    val updateNoteUseCase by lazy { UpdateNoteUseCase(notesRepository) }
}
