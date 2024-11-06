package model.ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/demo";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "12345678";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
