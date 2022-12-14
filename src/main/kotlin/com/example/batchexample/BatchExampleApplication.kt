package com.example.batchexample

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class BatchExampleApplication

fun main(args: Array<String>) {
    runApplication<BatchExampleApplication>(*args)
}
