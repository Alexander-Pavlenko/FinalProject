package dao.impl;

import model.Admin;
import model.Client;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 16.12.2016.
 */
public final class UserDaoImpl extends CRUDDAO<User> {
    private final String INSERT = "Insert into user (login, password, firstName, lastName, e_mail, isClient, money, discount) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE user SET login = ?, password = ?, firstName = ?, lastName = ?, e_mail = ?, isClient = ?, money = ?, discount = ?  WHERE id = ?";
    private final String FIND_BY_LOGIN = "Select * from user where login LIKE ?";
    private static UserDaoImpl crudDAO;
    public UserDaoImpl(Class type) {
        super(type);
    }
    public static synchronized UserDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new UserDaoImpl(User.class);
        }
        return crudDAO;
    }
    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getE_mail());
        preparedStatement.setBoolean(6, entity.isClient());
        preparedStatement.setDouble(7, entity.getMoney());
        preparedStatement.setDouble(8, entity.getDiscount());
        preparedStatement.setInt(9, entity.getId());



        return preparedStatement;
    }
    @Override
    public PreparedStatement createInsertStatement(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,user.getLogin());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getE_mail());
        preparedStatement.setBoolean(6, user.isClient());
        preparedStatement.setDouble(7, user.getMoney());
        preparedStatement.setDouble(8, user.getDiscount());
        return preparedStatement;
    }
    @Override
    public List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new ArrayList<>();
        User user;
        while (resultSet.next()) {
            if(resultSet.getBoolean("isClient"))
                user = new Client();
            else {
                user = new Admin();
            }
            user.setId(resultSet.getInt("id"));
            user.setE_mail(resultSet.getString("e_mail"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setPassword(resultSet.getString("password"));
            user.setLogin(resultSet.getString("login"));
            user.setClient(resultSet.getBoolean("isClient"));
            user.setMoney(resultSet.getDouble("money"));
            user.setDiscount(resultSet.getDouble("discount"));
            result.add(user);
        }
        return result;
    }
    public List<User> readAllByLogin(String login){
        List<User> result = new ArrayList<>();

        try(Connection connection = getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);) {
            preparedStatement.setString(1,login );
            ResultSet resultSet = preparedStatement.executeQuery();
            result = readAll(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}