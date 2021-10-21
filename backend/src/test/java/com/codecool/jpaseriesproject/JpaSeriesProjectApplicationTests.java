package com.codecool.jpaseriesproject;

import com.codecool.jpaseriesproject.enums.Status;
import com.codecool.jpaseriesproject.models.Episode;
import com.codecool.jpaseriesproject.models.Season;
import com.codecool.jpaseriesproject.models.Series;
import com.codecool.jpaseriesproject.repositories.EpisodeRepository;
import com.codecool.jpaseriesproject.repositories.SeasonRepository;
import com.codecool.jpaseriesproject.repositories.SeriesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JpaSeriesProjectApplicationTests {

    @Autowired
    SeasonRepository seasonRepository;
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    EpisodeRepository episodeRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllSeasons(){
        List<Season> seasons = seasonRepository.findAll();
        seasons.forEach(season -> System.out.println(season.getTitle()));
    }

    @Test
    public void testGetAllSeries(){
        List<Series> series = seriesRepository.findAll();
        series.forEach(series1 -> System.out.println(series1.getTitle()));
    }

    @Test
    public void testAddNewSeries(){
        Series series = new Series();
        series.setTitle("Alba ca zapada");
        series.setGenre(Arrays.asList("Comedy", "Action"));
        series.setHomepage("http://www.google.ro");
        series.setRating(7.99);
        series.setTrailer("trailer");
        series.setOverview("a fost odata ca-n povesti o fata frumoasa");
        series.setStatus(Status.ONGOING);


        Season season = new Season();
        season.setTitle("Cenusareasa si Printul");
        season.setSeason_number(2);
        season.setOverview("lorem ipsum");
        series.setSeasons(Arrays.asList(season));

        Episode episode = new Episode();
        episode.setTitle("Ep 1");
        episode.setOverview("lorem ipsum sin dolor");
        episode.setEpisode_number(1);

        season.setEpisodes(Arrays.asList(episode));

        seriesRepository.save(series);
        seasonRepository.save(season);
        episodeRepository.save(episode);

    }




}
