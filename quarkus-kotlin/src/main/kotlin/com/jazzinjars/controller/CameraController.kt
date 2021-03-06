package com.jazzinjars.controller

import com.jazzinjars.domain.Camera
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
    fun getAll(): Response = Response.ok(cameraRepository.listAll()).build()

    @POST
    @Transactional
    fun save(camera: Camera): Response {
        cameraRepository.persist(camera)
        return Response.ok().build()
    }

    @GET
    @Path("/{id}")
    fun getById(@PathParam(value = "id") id: Long): Response {
        var camera = cameraRepository.findById(id)
        return Response.ok(camera).build()
    }

    @GET
    @Path("/wishlist/{wish}")
    fun getByWishlist(@PathParam(value = "wish") wish: Boolean): Response {
        var camera = cameraRepository.findByWishlist(wish)
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
