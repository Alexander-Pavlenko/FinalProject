package model;

import lombok.Data;

/**
 * Created by Alexandr on 05.12.2016.
 */
@Data
public class Ticket extends Entity<Integer>  {
    private Place place;
    private double price;
    private User user;
    private Session session;


    public Ticket(){}


}
