package com.jazzinjars.testorderjupiter.infrastructure.framework

import org.junit.jupiter.api.ClassDescriptor
import org.junit.jupiter.api.ClassOrderer
import org.junit.jupiter.api.ClassOrdererContext
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest

class JupiterClassOrderer : ClassOrderer {

    override fun orderClasses(classOrdererContext: ClassOrdererContext?) {
        classOrdererContext?.classDescriptors?.sortedWith(compareBy { descriptor -> getOrder(descriptor) })
    }

    private fun getOrder(classDescriptor: ClassDescriptor): Int {
        return when {
            classDescriptor.findAnnotation(SpringBootTest::class.java).isPresent -> { 4 }
            classDescriptor.findAnnotation(WebMvcTest::class.java).isPresent -> { 3 }
            classDescriptor.findAnnotation(DataJpaTest::class.java).isPresent -> { 2 }
            else -> { 1 }
        }
    }
}
