package org.bonespirito.jsonserializer.application

import com.beust.klaxon.Klaxon
import org.bonespirito.jsonserializer.domain.DocumentVo
import org.bonespirito.jsonserializer.infraestructure.persistence.DocumentRepository
import org.bonespirito.jsonserializer.utils.toDocumentEntity
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DocumentService(
    @Autowired
    private val documentRepository: DocumentRepository
) {
    val logger = LoggerFactory.getLogger(DocumentService::class.java)
    fun create(documentVo: DocumentVo) {
        logger.info("Creating document $documentVo")
        logger.info("Document data: ${Klaxon().toJsonString(documentVo.data)}")
        logger.info("Try to save document")
        documentRepository.save(documentVo.toDocumentEntity())
    }
}
