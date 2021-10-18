package com.codecool.jpaseriesproject.repositories;

import com.codecool.jpaseriesproject.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
