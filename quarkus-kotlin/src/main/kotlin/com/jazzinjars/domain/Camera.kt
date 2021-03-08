package com.jazzinjars.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

@Entity
class Camera: PanacheEntity() {
    lateinit var model: String

}
