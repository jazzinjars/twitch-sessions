package com.jazzinjars.controller

import com.jazzinjars.domain.Camera
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.get
import org.apache.http.HttpHeaders
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import javax.ws.rs.core.MediaType

@QuarkusTest
//@QuarkusTestResource(value = DatabaseResource::class)
@TestMethodOrder(value = MethodOrderer::class)
class CameraResourceTest {

    @Test
    @Order(1)
    internal fun `initial items`() {
        val jsonCameras = get("/cameras")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .extract().body().jsonPath()
        var cameras = jsonCameras.getList("", Camera::class.java)

        assertEquals(5, cameras.size)
    }

    @Test
    @Order(2)
    internal fun `obtain one camera`() {
        val id = 1
        val jsonCamera = get("/cameras/$id")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .extract().body().jsonPath()
        var camera = jsonCamera.getObject("", Camera::class.java)

        assertEquals("A7III", camera.model)
    }
}
