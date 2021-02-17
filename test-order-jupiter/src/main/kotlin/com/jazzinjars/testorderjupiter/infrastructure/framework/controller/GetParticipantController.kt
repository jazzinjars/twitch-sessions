package com.jazzinjars.testorderjupiter.infrastructure.framework.controller

import com.jazzinjars.testorderjupiter.domain.DNI
import com.jazzinjars.testorderjupiter.domain.Participant
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/participants", produces = [MediaType.APPLICATION_JSON_VALUE])
class GetParticipantController {

    @GetMapping
    @ResponseBody
    fun findBy(@RequestParam(value = "dni") dni: String) =
        ResponseEntity
            .ok()
            .body(
                Participant(DNI(dni), "Jon Viene")
            )
}
