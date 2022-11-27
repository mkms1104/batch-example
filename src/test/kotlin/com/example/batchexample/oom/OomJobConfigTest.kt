package com.example.batchexample.oom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBatchTest
@SpringBootTest
internal class OomJobConfigTest {
    @Autowired private lateinit var jobLauncherTestUtils: JobLauncherTestUtils

    @Test
    fun test() {
        val list = mutableListOf<Temp>()
        val aaa = Array(Int.MAX_VALUE * Int.MAX_VALUE) { 1 }
        for(i in 1..300_000_000) {
            list.add(Temp())

        }
    }
    class Temp {

    }
}