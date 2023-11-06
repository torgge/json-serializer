package org.bonespirito.jsonserializer.infraestructure.persistence.entities

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import org.springframework.data.annotation.Id

@DynamoDBTable(tableName = "Document")
data class DocumentEntity(
    @Id
    @DynamoDBHashKey(attributeName = "id")
    @DynamoDBAutoGeneratedKey
    var uuid: String,
    @DynamoDBRangeKey
    var createdAt: String,
    var data: String?,
) {
    constructor() : this("", "", "")
}
