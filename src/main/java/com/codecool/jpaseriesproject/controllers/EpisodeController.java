package com.codecool.jpaseriesproject.controllers;


import com.codecool.jpaseriesproject.models.Episode;
import com.codecool.jpaseriesproject.repositories.EpisodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "episodes/")
@AllArgsConstructor
@CrossOrigin
public class EpisodeController {

    private final EpisodeRepository episodeRepository;


    @GetMapping
    public List<Episode> getAllEpisodes(){
        return episodeRepository.findAll();
    }
}
