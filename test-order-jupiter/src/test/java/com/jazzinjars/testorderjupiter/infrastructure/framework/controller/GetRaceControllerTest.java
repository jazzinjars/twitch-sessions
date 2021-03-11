package com.jazzinjars.testorderjupiter.infrastructure.framework.controller;

import com.jazzinjars.testorderjupiter.domain.Race;
import com.jazzinjars.testorderjupiter.domain.RaceFinder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetRaceController.class)
public class GetRaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RaceFinder raceFinder;

    @Test
    void shouldGetRaceById() throws Exception {
        Mockito.when(raceFinder.findById(1L))
                .thenReturn(Optional.of(new Race(1L, "Collserola")));

        mockMvc.perform(get("/v1/races/{id}", 1L))
                .andExpect(status().isOk());
    }
}
