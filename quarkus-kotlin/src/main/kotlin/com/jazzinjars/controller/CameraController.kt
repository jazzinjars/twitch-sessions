package com.jazzinjars.controller

import com.jazzinjars.insfrastructure.persistence.CameraRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cameras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CameraController {

    @Inject
    lateinit var cameraRepository: CameraRepository

    @GET
    @Transactional
    fun getAll(): Response {
        var cameras = cameraRepository.findAll()
        return Response.ok(cameras).build()
    }

    @GET
    @Path("/{brand}")
    fun getByBrand(@PathParam(value = "brand") brand: String): Response {
        var cameras = cameraRepository.findByBrand(brand)
        return Response.ok(cameras).build()
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    fun deleteOne(@PathParam(value = "id") id: Long): Response {
        cameraRepository.deleteById(id)
        return Response.ok().build()
    }
}
