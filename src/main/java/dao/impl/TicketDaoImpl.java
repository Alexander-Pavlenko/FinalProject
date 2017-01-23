package dao.impl;

import model.Place;
import model.Ticket;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 18.12.2016.
 */
public class TicketDaoImpl extends CRUDDAO<Ticket> {
    private final String INSERT = "INSERT INTO ticket(columPlace, rowPlace, price, idUser, idSession) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE ticket SET columnPlace = ?, rowPlace = ?, price = ?, idUser = ?, idSession = ? WHERE id = ?";
    private static TicketDaoImpl crudDAO;

    public TicketDaoImpl(Class<Ticket> type) {
        super(type);
    }




    public static synchronized TicketDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new TicketDaoImpl(Ticket.class);
        }
        return crudDAO;
    }
    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Ticket entity) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getPlace().getColumn());
        preparedStatement.setInt(2, entity.getPlace().getRow());
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getUser().getId());
        preparedStatement.setInt(5, entity.getSession().getId());
        preparedStatement.setInt(6, entity.getId());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Ticket entity) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getPlace().getColumn());
        preparedStatement.setInt(2, entity.getPlace().getRow());
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getUser().getId());
        preparedStatement.setInt(5, entity.getSession().getId());

        return preparedStatement;
    }

    @Override
    protected List<Ticket> readAll(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException {
        List<Ticket> ticketList = new ArrayList<>();
        while (resultSet.next()){
            Ticket ticket = new Ticket();

            ticket.setId(resultSet.getInt("id"));
            ticket.setUser(UserDaoImpl.getInstance().getById(resultSet.getInt("idUser")));
            ticket.setSession(SessionDaoImpl.getInstance().getById(resultSet.getInt("idSession")));
            ticket.setPrice(resultSet.getDouble("price"));
            ticket.setPlace(new Place(resultSet.getInt("columPlace"), resultSet.getInt("rowPlace")));


            ticketList.add(ticket);
        }
        return ticketList;
    }
}
