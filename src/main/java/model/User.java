package model;

import lombok.Data;

/**
 * Created by Alexandr on 05.12.2016.
 */
@Data
public class User extends Entity<Integer> {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String e_mail;
    private double discount;
    private double money;
    private boolean isClient;
    public User(){}
    public User(String login, String password, String e_mail) {
        this.login = login;
        this.password = password;
        this.e_mail = e_mail;

    }

    public String returnFullName(){
        return firstName + " " + lastName;
    }
}
