package dao.impl;

import model.Session;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class SessionDaoImpl extends CRUDDAO<Session> {

    private final String INSERT = "INSERT INTO session(idFilm, idHall, dateShow) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE SESSION SET idFilm = ?, idHall = ?, dateShow= ? WHERE id = ?";
    public static final String FIND_BY_IDFILM = "Select * from session where idFilm = ?";
    private static SessionDaoImpl crudDAO;


    public static synchronized SessionDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new SessionDaoImpl(Session.class);
        }
        return crudDAO;
    }

    public SessionDaoImpl(Class<Session> type) {
        super(type);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Session entity) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getFilm().getId());
        preparedStatement.setInt(2, entity.getHall().getId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getDate()));
        preparedStatement.setInt(4, entity.getId());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Session entity) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getFilm().getId());
        preparedStatement.setInt(2, entity.getHall().getId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getDate()));
        return preparedStatement;
    }

    @Override
    protected List<Session> readAll(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException {
        List<Session> sessionList = new ArrayList<>();
        while (resultSet.next()){
            Session session = new Session();

            session.setId(resultSet.getInt("id"));
            session.setHall(HallDaoImpl.getInstance().getById(resultSet.getInt("idHall")));
            session.setFilm(FilmDaoImpl.getInstance().getById(resultSet.getInt("idFilm")));
            session.setDate(resultSet.getTimestamp("dateShow").toLocalDateTime());


            sessionList.add(session);
        }
        return sessionList;

    }

    public List<Session> getByFilmId(Integer id) {

        Connection connection = getDataSource().getConnection();
        List<Session> result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDFILM);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
