package com.jazzinjars.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@RestController
@RequestMapping("/health")
class HealthController {

    @GetMapping(produces = [MediaType.APPLICATION_JSON])
    fun check() = "Health RESTEasy"
}
