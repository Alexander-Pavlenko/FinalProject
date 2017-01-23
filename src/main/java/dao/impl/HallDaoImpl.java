package dao.impl;

import model.Hall;
import model.Place;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 17.12.2016.
 */
public class HallDaoImpl extends CRUDDAO<Hall> {
    private final String INSERT = "INSERT INTO hall(countColumes, countRows, places, nameHall) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE hall SET countColumes = ?, countRows = ?, places = ?, nameHall = ? WHERE id = ?";
    private static HallDaoImpl crudDAO;



    public HallDaoImpl(Class<Hall> type) {
        super(type);
    }
    public static synchronized HallDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new HallDaoImpl(Hall.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Hall entity) throws SQLException, IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(entity.getPlaces());

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getCountColume());
        preparedStatement.setInt(2, entity.getCountRow());
        preparedStatement.setBytes(3, baos.toByteArray());
        preparedStatement.setString(4, entity.getName());
        preparedStatement.setInt(5, entity.getId());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Hall entity) throws SQLException, IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(entity.getPlaces());

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getCountColume());
        preparedStatement.setInt(2, entity.getCountRow());
        preparedStatement.setBytes(3, baos.toByteArray());
        preparedStatement.setString(4, entity.getName());


        return preparedStatement;
    }

    @Override
    protected List<Hall> readAll(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException {
        List<Hall> hallList = new ArrayList<>();
            while (resultSet.next()){
                Hall hall = new Hall();

                hall.setId(resultSet.getInt("id"));
                hall.setCountColume(resultSet.getInt("countColumes"));
                hall.setCountRow(resultSet.getInt("countRows"));
                ByteArrayInputStream bais = new ByteArrayInputStream(resultSet.getBytes("places"));
                ObjectInputStream ois = new ObjectInputStream(bais);
                hall.setPlaces((Place[][]) ois.readObject());
                hall.setName(resultSet.getString("nameHall"));


                hallList.add(hall);
            }
            return hallList;

        }
}
