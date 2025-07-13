package com.college.feedback.Feedback;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBConnectionPool {
    private static BasicDataSource ds;

    static {
        try {
            Properties props = new Properties();
            InputStream in = DBConnectionPool.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(in);

            ds = new BasicDataSource();
            ds.setDriverClassName(props.getProperty("jdbc.driver"));
            ds.setUrl(props.getProperty("jdbc.url"));
            ds.setUsername(props.getProperty("jdbc.username"));
            ds.setPassword(props.getProperty("jdbc.password"));

            ds.setInitialSize(5);
            ds.setMaxTotal(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
