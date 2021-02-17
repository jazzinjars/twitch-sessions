package com.jazzinjars.testorderjupiter.infrastructure.framework.persistence;

import com.jazzinjars.testorderjupiter.domain.Race;
import com.jazzinjars.testorderjupiter.domain.RaceFinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class RaceFinderTest {

    @Autowired
    private RaceFinder raceFinder;

    @Test
    void shouldSaveRace() {
        Race race = raceFinder.save(new Race(1, "Collserola"));
        assertThat(race).isNotNull();
    }
}
