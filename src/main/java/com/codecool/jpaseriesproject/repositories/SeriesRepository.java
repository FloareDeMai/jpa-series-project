package com.codecool.jpaseriesproject.repositories;

import com.codecool.jpaseriesproject.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

    Series findByTitle(String title);
    List<Series> findByRating(double rating);
    List<Series> findByRatingGreaterThan(double rating);
    List<Series> findByGenreIgnoreCase(String genre);

}
