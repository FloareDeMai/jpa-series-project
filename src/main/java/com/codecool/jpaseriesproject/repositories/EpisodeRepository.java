package com.codecool.jpaseriesproject.repositories;

import com.codecool.jpaseriesproject.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
