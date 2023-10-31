package org.bonespirito.jsonserializer.utils

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import org.bonespirito.jsonserializer.domain.DocumentVo
import org.bonespirito.jsonserializer.infraestructure.resource.dto.DocumentDto

fun DocumentDto.toDocumentVo(): DocumentVo {
    return DocumentVo(
        uuid = this.uuid,
        createdAt = this.createdAt,
        data = Parser.default().parse(StringBuilder(this.data)) as JsonObject,
    )
}
