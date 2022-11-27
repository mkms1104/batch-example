package com.example.batchexample.oom

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepExecution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.support.IteratorItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OomJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {
    private var count = 0

    @Bean
    fun oomJob(): Job {
        return jobBuilderFactory.get("oom.job")
            .start(oomStep())
            .listener(object : JobExecutionListenerSupport(){
                override fun afterJob(jobExecution: JobExecution) {
                    println("writer 호출 횟수 : $count")
                }
            })
            .build()
    }

    @Bean
    fun oomStep(): Step {
        return stepBuilderFactory.get("oom.step")
            .chunk<Int, Int>(1000)
            .reader(oomReader())
            .writer(oomWriter())
            .build()
    }

    @Bean
    fun oomReader(): IteratorItemReader<Int> {
        val iter = (1..10000).iterator()
        return IteratorItemReader(iter)
    }

    @Bean
    fun oomWriter(): ItemWriter<Int> {
        return ItemWriter {
            it.forEach { item ->
                val temp = TempClass()
            }
        }
    }

    class TempClass {

    }
}