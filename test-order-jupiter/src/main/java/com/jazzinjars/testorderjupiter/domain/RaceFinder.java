package com.jazzinjars.testorderjupiter.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceFinder extends CrudRepository<Race, Long> {
}
