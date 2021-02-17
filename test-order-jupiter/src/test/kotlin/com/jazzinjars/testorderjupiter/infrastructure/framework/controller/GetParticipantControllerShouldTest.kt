package com.jazzinjars.testorderjupiter.infrastructure.framework.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class GetParticipantControllerShouldTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `retrieve participant by DNI`() {
        mockMvc.get("/v1/participants") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            param("dni", "12345678L")
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json("{}") }
        }
    }
}
