package org.bonespirito.jsonserializer.infraestructure.persistence

import org.bonespirito.jsonserializer.infraestructure.persistence.entities.DocumentEntity
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository

@EnableScan
interface DocumentRepository : CrudRepository<DocumentEntity, String> {
    fun findByUuid(uuid: String): DocumentEntity?
}
