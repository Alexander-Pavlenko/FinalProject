package dto;

import lombok.Data;
import model.Entity;

import java.time.LocalDateTime;

/**
 * Created by Alexandr on 17.12.2016.
 */
@Data
public class SessionDto extends Entity<Integer> {
    private FilmDto filmDto;
    private HallDto hallDto;
    private LocalDateTime date;
}
