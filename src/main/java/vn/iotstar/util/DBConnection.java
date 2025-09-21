package vn.iotstar.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DB_NAME = "web_java";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    private static final String PARAMS =
            "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + PARAMS;
            return DriverManager.getConnection(url, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("DB Connection error", e);
        }
    }
}
