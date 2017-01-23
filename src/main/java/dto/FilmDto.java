package dto;

import lombok.Data;
import model.Entity;

/**
 * Created by Alexandr on 17.12.2016.
 */
@Data
public class FilmDto extends Entity<Integer> {
    private String name;
    private DescriptionDto description;
}
