package com.example.composetask.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val imageUrl: String,
    val name: String,
    val category: String,
    val desc: String
)