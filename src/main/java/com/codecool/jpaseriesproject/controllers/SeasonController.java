package com.codecool.jpaseriesproject.controllers;


import com.codecool.jpaseriesproject.models.Season;
import com.codecool.jpaseriesproject.repositories.SeasonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/seasons")
@AllArgsConstructor
@CrossOrigin
public class SeasonController {

    private final SeasonRepository seasonRepository;

    @GetMapping
    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Season> getEpisodesBySeasonId(@PathVariable("id") Long id){
        return seasonRepository.findById(id);
    }


}
