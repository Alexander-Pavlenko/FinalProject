package dao.impl;

import model.Description;
import model.FormatFilm;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 16.12.2016.
 */
public class DescriptionDaoImpl extends CRUDDAO<Description> {
    private final String INSERT = "Insert into description(duration, miniDescription, timeDate, formatFilm, picture, mark) values (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE description SET duration = ?, miniDescription = ?, timeDate = ?, formatFilm = ?, picture = ?, mark = ? WHERE id = ?";
    private static DescriptionDaoImpl crudDAO;
    public DescriptionDaoImpl(Class type) {
        super(type);
    }
    public static synchronized DescriptionDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new DescriptionDaoImpl(Description.class);
        }
        return crudDAO;
    }
    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Description entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getDuration());
        preparedStatement.setString(2, entity.getMiniDescription());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getRelease()));
        preparedStatement.setString(4, entity.getFormatFilm().getStringName());
        preparedStatement.setString(5, entity.getPicture());
        preparedStatement.setDouble(6, entity.getMark());
        preparedStatement.setInt(7, entity.getId());


        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Description entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, entity.getDuration());
        preparedStatement.setString(2, entity.getMiniDescription());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getRelease()));
        preparedStatement.setString(4, entity.getFormatFilm().getStringName());
        preparedStatement.setString(5, entity.getPicture());
        preparedStatement.setDouble(6, entity.getMark());
        return preparedStatement;
    }

    @Override
    protected List<Description> readAll(ResultSet resultSet) throws SQLException {
        List<Description> result = new ArrayList<>();
        Description description;
        while (resultSet.next()) {

            description = new Description();
            description.setId(resultSet.getInt("id"));
            description.setDuration(resultSet.getInt("duration"));
            description.setMiniDescription(resultSet.getString("miniDescription"));
            try {
                description.setRelease(resultSet.getTimestamp("timeDate").toLocalDateTime());

            }
            catch (Exception e){
                description.setRelease(LocalDateTime.now());
            }
            description.setFormatFilm(FormatFilm.getFormatFilm(resultSet.getString("formatFilm")));
            description.setPicture(resultSet.getString("picture"));
            description.setMark(resultSet.getDouble("mark"));

            result.add(description);
        }
        return result;
    }
}
