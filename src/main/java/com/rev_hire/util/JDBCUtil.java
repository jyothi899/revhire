package com.rev_hire.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    private static final String URL =
            "jdbc:mysql://localhost:3306/rev_hire_db";

    private static final String USER = "root";
    private static final String PASSWORD = "root";   // change if needed

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Loading Failed");
            e.printStackTrace();
        }
    }

    private JDBCUtil() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}