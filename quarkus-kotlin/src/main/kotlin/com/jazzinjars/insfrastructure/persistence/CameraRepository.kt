package com.jazzinjars.insfrastructure.persistence

import com.jazzinjars.domain.Camera
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CameraRepository: PanacheRepository<Camera> {
    fun findByBrand(brand: String) = list("brand", brand)
}
