package org.bonespirito.jsonserializer.infraestructure.resource

import org.bonespirito.jsonserializer.application.DocumentService
import org.bonespirito.jsonserializer.infraestructure.resource.dto.DocumentDto
import org.bonespirito.jsonserializer.utils.toDocumentVo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/documents")
class DocumentResource(
    @Autowired
    private val documentService: DocumentService,
) {

    val logger = org.slf4j.LoggerFactory.getLogger(DocumentResource::class.java)

    @PostMapping
    fun create(
        @RequestBody body: DocumentDto,
    ): ResponseEntity<DocumentDto> {
        val resource = body.copy(uuid = java.util.UUID.randomUUID())

        logger.info("Creating document: $resource")

        val documentVo = resource.toDocumentVo()

        this.documentService.create(documentVo)

        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resource.uuid).toUri(),
        ).build()
    }
}
