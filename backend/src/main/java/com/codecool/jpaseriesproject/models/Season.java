package com.codecool.jpaseriesproject.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {
    @SequenceGenerator(name = "season_sequence", sequenceName = "season_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "season_sequence")
    @Id
    private Long id;
    private int season_number;
    private String title;
    @Column(length = 1000)
    private String overview;
    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonBackReference
    private Series series;
    @OneToMany(mappedBy = "season")
    @JsonManagedReference
    private List<Episode> episodes;

    public Season(int season_number, String title, String overview, Series series, List<Episode> episodes) {
        this.season_number = season_number;
        this.title = title;
        this.overview = overview;
        this.series = series;
        this.episodes = episodes;
    }
}
