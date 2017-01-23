package dto;

import lombok.Data;
import model.Entity;
import model.FormatFilm;

import java.time.LocalDateTime;


/**
 * Created by Alexandr on 17.12.2016.
 */
@Data
public class DescriptionDto extends Entity<Integer> {
    private int duration;
    private String miniDescription;
    private LocalDateTime Release;
    private FormatFilm formatFilm;
    private String picture;
    private double mark;

}
