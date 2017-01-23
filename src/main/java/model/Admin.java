package model;

/**
 * Created by Alexandr on 05.12.2016.
 */
public class Admin extends User {

    public Admin(String login, String password, String e_meil) {
        super(login, password, e_meil);
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Login: " + getLogin() + '\n' +
                "E-meil" + getE_mail();
    }
}
