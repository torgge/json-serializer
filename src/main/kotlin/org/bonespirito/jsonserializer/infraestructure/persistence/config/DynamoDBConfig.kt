package org.bonespirito.jsonserializer.infraestructure.persistence.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.bonespirito.jsonserializer.infraestructure.persistence.DocumentRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackageClasses = [DocumentRepository::class])
@ComponentScan(
    basePackages = [
        "org.bonespirito.jsonserializer.*",
    ],
)
class DynamoDBConfig(
    @Value("\${aws.accessKeyId}") private val awsAccessKeyId: String,
    @Value("\${aws.secretKey}") private val awsSecretKey: String,
    @Value("\${aws.region}") private val awsRegion: String,
    @Value("\${aws.dynamoDBUrl}") private val awsEndpoint: String,
) {

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB =
        AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(awsEndpoint, awsRegion))
            .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(awsAccessKeyId, awsSecretKey)))
            .build()
}
