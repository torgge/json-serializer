package org.bonespirito.jsonserializer.application

import com.beust.klaxon.Klaxon
import org.bonespirito.jsonserializer.domain.DocumentVo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DocumentService {
    val logger = LoggerFactory.getLogger(DocumentService::class.java)

    fun create(documentVo: DocumentVo) {
        logger.info("Creating document $documentVo")
        logger.info("Document data: ${Klaxon().toJsonString(documentVo.data)}")
    }
}
