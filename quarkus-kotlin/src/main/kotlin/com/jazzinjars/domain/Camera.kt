package com.jazzinjars.domain

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import javax.persistence.Entity

@Entity
data class Camera(
    var brand: String = "",
    var model: String = "",
    var wishlist: Boolean = true
) : PanacheEntity()
