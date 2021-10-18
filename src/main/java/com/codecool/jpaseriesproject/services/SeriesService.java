package com.codecool.jpaseriesproject.services;

import com.codecool.jpaseriesproject.models.Series;
import com.codecool.jpaseriesproject.repositories.SeriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeriesService {

    private final SeriesRepository seriesRepository;



}
