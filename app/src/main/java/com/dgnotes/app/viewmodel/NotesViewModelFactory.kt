package com.dgnotes.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dgnotes.app.di.AppModule

object NotesViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(
            getNotes = AppModule.getNotesUseCase,
            addNoteUseCase = AppModule.addNoteUseCase,
            deleteNoteUseCase = AppModule.deleteNoteUseCase,
            updateNoteUseCase = AppModule.updateNoteUseCase
        ) as T
    }
}
