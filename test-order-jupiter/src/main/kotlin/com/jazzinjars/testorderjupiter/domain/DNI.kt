package com.jazzinjars.testorderjupiter.domain

data class DNI(private val value: String) {
    fun asString(): String {
        return value
    }
}
