package org.bonespirito.jsonserializer.domain

import com.beust.klaxon.JsonObject
import java.time.LocalDate
import java.util.*

data class DocumentVo(
    val uuid: UUID,
    val createdAt: LocalDate,
    val data: JsonObject
)
