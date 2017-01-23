package dao;

import dao.api.Dao;
import dao.impl.*;
import dbProperty.PropertyHolder.PropertyHolder;
import lombok.Data;
import model.*;

/**
 * Created by Alexandr on 16.12.2016.
 */
@Data
public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Film> filmDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Description> descriptionDao;
    private Dao<Integer, Hall> hallDao;
    private Dao<Integer, Session> sessionDao;
    private Dao<Integer, Ticket> ticketDao;




    private DaoFactory(){
        loadDaos();
    }
    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }


    private void loadDaos() {
        if(PropertyHolder.getInstance().isInMemoryDB()){
        }else{
            userDao = new UserDaoImpl(User.class);
            descriptionDao = new DescriptionDaoImpl(Description.class);
            hallDao = new HallDaoImpl(Hall.class);
            filmDao = new FilmDaoImpl(Film.class);
            sessionDao = new SessionDaoImpl((Session.class));
            ticketDao = new TicketDaoImpl(Ticket.class);
        }
    }

}