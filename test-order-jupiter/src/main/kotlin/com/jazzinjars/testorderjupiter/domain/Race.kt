package com.jazzinjars.testorderjupiter.domain

import java.util.*

data class Race(
    val endDate: Date,
    val participants: List<Participant>
)
