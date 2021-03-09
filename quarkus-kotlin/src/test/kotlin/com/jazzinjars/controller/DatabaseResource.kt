package com.jazzinjars.controller

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import java.util.*

class DatabaseResource: QuarkusTestResourceLifecycleManager {

    companion object {
        @Container
        private val postgreSQLContainer = PostgreSQLContainer<Nothing>("postgres:latest").apply {
            withDatabaseName("test_db")
            withUsername("root")
            withPassword("root")
            withExposedPorts(5432)
        }
    }

    override fun start(): MutableMap<String, String> {
        postgreSQLContainer.start();
        return Collections.singletonMap("quarkus.datasource.jdbc.url", postgreSQLContainer.jdbcUrl)
    }

    override fun stop() {
        postgreSQLContainer.stop()
    }
}
