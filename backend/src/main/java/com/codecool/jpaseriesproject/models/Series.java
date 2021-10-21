package com.codecool.jpaseriesproject.models;

import com.codecool.jpaseriesproject.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Series {
    @Id
    @SequenceGenerator(name = "series_sequence", sequenceName = "series_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "series_sequence")
    private Long id;
    private String title;
    private String year;
    @Column(length = 1000)
    private String overview;
    private int runtime;
    private String trailer;
    private String homepage;
    private String pictureLink;
    private double rating;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "series")
    @JsonManagedReference
    private List<Season> seasons;
    @ElementCollection
    @CollectionTable(name="series_genres", joinColumns = @JoinColumn(name = "show_id"))
    @Column(name = "genres")
    private List<String> genre;

    public Series(String title, String year, String overview, int runtime, String trailer, String homepage, double rating, Status status, List<Season> seasons) {
        this.title = title;
        this.year = year;
        this.overview = overview;
        this.runtime = runtime;
        this.trailer = trailer;
        this.homepage = homepage;
        this.rating = rating;
        this.status = status;
        this.seasons = seasons;
    }
}
