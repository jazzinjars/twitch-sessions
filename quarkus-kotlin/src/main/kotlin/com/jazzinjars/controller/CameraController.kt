package com.jazzinjars.controller

import com.jazzinjars.insfrastructure.persistence.CameraRepository
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
    fun getAll(): Response {
        var cameras = cameraRepository.findAll()
        return Response.ok(cameras).build()
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam(value = "id") id: Long): Response {
        var camera = cameraRepository.findById(id)
        return Response.ok(camera).build()
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    fun deleteOne(@PathParam(value = "id") id: Long): Response {
        cameraRepository.deleteById(id)
        return Response.ok().build()
    }
}
