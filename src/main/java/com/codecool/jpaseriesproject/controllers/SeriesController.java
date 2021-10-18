package com.codecool.jpaseriesproject.controllers;


import com.codecool.jpaseriesproject.models.Series;
import com.codecool.jpaseriesproject.repositories.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/series")
@AllArgsConstructor
@CrossOrigin
public class SeriesController {

    private final SeriesRepository seriesRepository;

    @GetMapping
    public List<Series> getAllSeries(){
        return seriesRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Series> getSeasonsBySeriesId(@PathVariable("id") Long id){
        return seriesRepository.findById(id);
    }

    @GetMapping(path = "/{rating}/shows-by-rating")
    public List<Series> getShowsByRating(@PathVariable("rating") double rating){
        return seriesRepository.findByRating(rating);
    }

    @GetMapping(path = "/{rating}/rating-greater")
    public List<Series> getShowsByRatingGreaterThan(@PathVariable("rating") double rating){
        return seriesRepository.findByRatingGreaterThan(rating);
    }

    @GetMapping(path = "/{genre}/by-genre-containing")
    public List<Series> getShowsByGenre(@PathVariable("genre") String genre){
        return seriesRepository.findByGenreIgnoreCase(genre);
    }

    @PostMapping(path = "/add-series")
    public void addNewSeries(@RequestBody Series series){
        if(seriesRepository.findByTitle(series.getTitle())!= null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This series already exists in database");
        }else {
            seriesRepository.save(series);
        }
    }

    @PutMapping(path = "/{id}/update-by-id")
    public void updateSeries(@PathVariable("id")Long id, @RequestBody Series series){
        Optional<Series> series1 = seriesRepository.findById(id);
        if(series1.isPresent()){
            series1.get().setTitle(series.getTitle());
            series1.get().setGenre(series.getGenre());
            series1.get().setStatus(series.getStatus());
            series1.get().setTrailer(series.getTrailer());
            series1.get().setRating(series.getRating());
            series1.get().setHomepage(series.getHomepage());
            series1.get().setYear(series.getYear());
            series1.get().setOverview(series.getOverview());
            seriesRepository.save(series1.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This series doesn't exist!");
        }

    }

    @DeleteMapping(path = "/{id}/delete-series")
    public void deleteSeries(@PathVariable("id") Long id){
        Optional<Series> series =  seriesRepository.findById(id);
       if(series.isPresent()){
           seriesRepository.delete(series.get());
       }else{
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This series doesn't exist!");
       }
    }


}
