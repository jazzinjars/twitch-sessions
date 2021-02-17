package com.jazzinjars.testorderjupiter.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class RaceTest {
    @Test
    fun `a race has an end date and participants`() {
        val endDate = Date()
        val participants = listOf(Participant(DNI("12345678L"), "Jon Viene"))
        val race = Race(endDate, participants)

        assertThat(race.endDate).isNotNull
        assertThat(race.participants).isNotEmpty
    }
}
