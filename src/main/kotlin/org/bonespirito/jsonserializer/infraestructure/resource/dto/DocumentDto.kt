package org.bonespirito.jsonserializer.infraestructure.resource.dto

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

data class DocumentDto(
    val uuid: UUID = UUID.randomUUID(),
    val createdAt: LocalDate = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    val data: String
)
