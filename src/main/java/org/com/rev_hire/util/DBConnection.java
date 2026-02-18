package org.com.rev_hire.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final Logger logger = LogManager.getLogger(DBConnection.class);

    private static final String URL = "jdbc:mysql://localhost:3306/revhire_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            logger.info("JDBC Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            logger.error("Driver Loading Failed", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        logger.info("Database Connection Established");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
