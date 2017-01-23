package dto;

import lombok.Data;
import model.Entity;

/**
 * Created by Alexandr on 16.12.2016.
 */
@Data
public class UserDto extends Entity<Integer> {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String e_mail;
    private double discount;
    private double money;
    private boolean isClient;
    public boolean getIsClient(){
        return isClient;
    }

    public double getDiscountPrice(double sum){
        return sum - discount;
    }
    public void changeDiscount(int countTicket){
        if(this.discount + countTicket > 40 )
            this.discount = 40;
        else
            this.discount += countTicket;
    }
}
