package dbProperty.dataSource;

/**
 * Created by Alexandr on 16.12.2016.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dbProperty.PropertyHolder.PropertyHolder;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public final class DataSource {
    private static ComboPooledDataSource poolConnections;
    private static DataSource dataSource;
    private DataSource() {
        initPollConnections();
    }
    public static synchronized DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = poolConnections.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static void initPollConnections() {
        poolConnections = new ComboPooledDataSource();
        PropertyHolder propertyHolder = PropertyHolder.getInstance();
        try {
            poolConnections.setDriverClass(propertyHolder.getDbDriver()); //loads the jdbc driver
            poolConnections.setJdbcUrl(propertyHolder.getJdbcUrl());
            poolConnections.setUser(propertyHolder.getDbUserLogin());
            poolConnections.setPassword(propertyHolder.getDbUserPassword());
            poolConnections.setMinPoolSize(5);
            poolConnections.setAcquireIncrement(1);
            poolConnections.setMaxPoolSize(100);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}