package dto;

import lombok.Data;
import model.Entity;
import model.Place;

/**
 * Created by Alexandr on 18.12.2016.
 */
@Data
public class TicketDto extends Entity<Integer> {
    private Place place;
    private double price;
    private UserDto userDto;
    private SessionDto sessionDto;



}
