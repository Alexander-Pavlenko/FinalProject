package model;

import lombok.Data;

import java.time.LocalDateTime;


/**
 * Created by Alexandr on 16.12.2016.
 */
@Data
public class Description extends Entity<Integer> {
    private int duration;
    private String miniDescription;
    private LocalDateTime Release;
    private FormatFilm formatFilm;
    private String picture;
    private double mark;

}
