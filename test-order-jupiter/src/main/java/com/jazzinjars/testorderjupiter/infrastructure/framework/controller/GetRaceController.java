package com.jazzinjars.testorderjupiter.infrastructure.framework.controller;

import com.jazzinjars.testorderjupiter.domain.Race;
import com.jazzinjars.testorderjupiter.domain.RaceFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/races")
public class GetRaceController {

    private final RaceFinder raceFinder;

    @Autowired
    public GetRaceController(RaceFinder raceFinder) {
        this.raceFinder = raceFinder;
    }

    @GetMapping("/{id}")
    public Race getRace(@PathVariable long id) {
        return raceFinder.findById(id).orElseThrow();
    }
}
