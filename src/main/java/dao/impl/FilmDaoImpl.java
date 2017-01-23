package dao.impl;

import model.Film;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class FilmDaoImpl extends CRUDDAO<Film> {
    private final String INSERT = "INSERT INTO film(nameFilm, idDescription) VALUES (?,?)";
    private final String UPDATE = "UPDATE film SET nameFilm = ?, idDescription = ? WHERE id = ?";
    private static FilmDaoImpl crudDAO;


    public FilmDaoImpl(Class<Film> type) {
        super(type);
    }

    public static synchronized FilmDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new FilmDaoImpl(Film.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Film entity) throws SQLException, IOException {

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getDescription().getId());
        preparedStatement.setInt(3, entity.getId());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Film entity) throws SQLException, IOException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getDescription().getId());

        return preparedStatement;
    }

    @Override
    protected List<Film> readAll(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException {
        List<Film> result = new ArrayList<>();
        Film film;
        while (resultSet.next()) {

            film = new Film();
            film.setId(resultSet.getInt("id"));
            film.setName(resultSet.getString("nameFilm"));
            film.setDescription(DescriptionDaoImpl.getInstance().getById
                    (resultSet.getInt("idDescription")));

            result.add(film);
        }
        return result;
    }






}
