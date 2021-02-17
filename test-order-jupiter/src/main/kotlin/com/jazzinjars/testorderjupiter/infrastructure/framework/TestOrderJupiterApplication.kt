package com.jazzinjars.testorderjupiter.infrastructure.framework

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestOrderJupiterApplication

fun main(args: Array<String>) {
	runApplication<TestOrderJupiterApplication>(*args)
}
