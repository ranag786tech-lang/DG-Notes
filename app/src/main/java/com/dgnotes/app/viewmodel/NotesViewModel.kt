package com.dgnotes.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgnotes.domain.model.Note
import com.dgnotes.domain.usecase.AddNoteUseCase
import com.dgnotes.domain.usecase.DeleteNoteUseCase
import com.dgnotes.domain.usecase.GetNotesUseCase
import com.dgnotes.domain.usecase.UpdateNoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    init {
        loadNotes()
    }

    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = runCatching { getNotes() }.getOrDefault(emptyList())
        }
    }

    fun addNote(text: String) {
        if (text.isBlank()) return
        viewModelScope.launch {
            addNoteUseCase(text.trim())
            loadNotes()
        }
    }

    fun deleteNote(id: String) {
        viewModelScope.launch {
            deleteNoteUseCase(id)
            loadNotes()
        }
    }

    fun updateNote(id: String, text: String) {
        if (text.isBlank()) return
        viewModelScope.launch {
            updateNoteUseCase(id, text.trim())
            loadNotes()
        }
    }
}
