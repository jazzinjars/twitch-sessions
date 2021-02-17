package com.jazzinjars.testorderjupiter.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void shouldCheckRace() {
        Race race = new Race(1, "Collserola");

        assertThat(race)
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getId()).isEqualTo(1L);
                    assertThat(r.getName()).isEqualTo("Collserola");
                });
    }
}
