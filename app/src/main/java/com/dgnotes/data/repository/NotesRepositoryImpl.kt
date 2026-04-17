package com.dgnotes.data.repository

import com.dgnotes.data.remote.SupabaseProvider
import com.dgnotes.domain.model.Note
import com.dgnotes.domain.repository.NotesRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.decodeList
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.filter

class NotesRepositoryImpl : NotesRepository {
    private val supabase = SupabaseProvider.client

    override suspend fun getNotes(): List<Note> {
        val userId = supabase.auth.currentUserOrNull()?.id ?: return emptyList()

        return supabase.from("notes")
            .select {
                filter {
                    eq("user_id", userId)
                }
            }
            .decodeList<Note>()
    }

    override suspend fun addNote(content: String) {
        val userId = supabase.auth.currentUserOrNull()?.id ?: return

        supabase.from("notes").insert(
            mapOf(
                "content" to content,
                "user_id" to userId
            )
        )
    }

    override suspend fun deleteNote(id: String) {
        supabase.from("notes").delete {
            filter {
                eq("id", id)
            }
        }
    }

    override suspend fun updateNote(id: String, content: String) {
        supabase.from("notes").update(
            mapOf("content" to content)
        ) {
            filter {
                eq("id", id)
            }
        }
    }
}
