package com.dgnotes.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: String,
    val content: String,
    val created_at: String,
    val user_id: String? = null
)
