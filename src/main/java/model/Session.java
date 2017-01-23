package model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Alexandr on 05.12.2016.
 */

@Data
public class Session extends Entity<Integer> {
    private Film film;
    private Hall hall;
    private LocalDateTime date;

    public Session() {

    }
}
