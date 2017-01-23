package dao.impl;

import dao.api.Dao;
import dbProperty.dataSource.DataSource;
import lombok.Getter;
import model.Entity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexandr on 16.12.2016.
 */
public abstract class CRUDDAO<T extends Entity<Integer>> implements Dao<Integer,T> {
    private Class<T> type;
    @Getter
    private DataSource dataSource;
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    public CRUDDAO(Class<T>  type) {
        this.type = type;
        dataSource = DataSource.getInstance();
    }
    @Override
    public List<T> getAll() {
        String sql = String.format(SELECT_ALL, type.getSimpleName());
        List result = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();){

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
    @Override
    public T getById(Integer id) {
        String sql = String.format(FIND_BY_ID, type.getSimpleName());

        List result = null;
        try ( Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
              ){
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
        return (T) result.get(0);
    }
    @Override
    public T save(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createInsertStatement(connection, entity);
             ){
                preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                entity.setId(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
    @Override
    public void update(T entity) {
        try ( Connection connection = dataSource.getConnection();
              PreparedStatement preparedStatement = createUpdateStatement(connection, entity)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Integer key) {
        String sql = String.format(DELETE_BY_ID, type.getSimpleName());
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected abstract PreparedStatement createUpdateStatement(Connection connection, T entity) throws SQLException, IOException;
    protected abstract PreparedStatement createInsertStatement(Connection connection, T entity) throws SQLException, IOException;
    protected abstract List<T> readAll(ResultSet resultSet) throws SQLException, IOException, ClassNotFoundException;
}
