package com.shorter.shorter.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "urls")
data class Url (
    @Id
    val shortUrl: String,
    val longUrl: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)