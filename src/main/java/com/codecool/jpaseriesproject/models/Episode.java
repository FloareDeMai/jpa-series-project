package com.codecool.jpaseriesproject.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Episode {
    @Id
    @SequenceGenerator(name = "episode_sequence", sequenceName = "episode_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "episode_sequence")
    private Long id;
    private String title;
    private int episode_number;
    @Column(length = 10000)
    private String overview;
    @ManyToOne
    @JoinColumn(name = "season_id")
    @JsonBackReference
    private Season season;

    public Episode(String title, int episode_number, String overview, Season season) {
        this.title = title;
        this.episode_number = episode_number;
        this.overview = overview;
        this.season = season;
    }
}
